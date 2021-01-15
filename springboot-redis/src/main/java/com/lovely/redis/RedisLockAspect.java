package com.lovely.redis;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * 核心切面拦截操作
 *
 * @author lovely
 * @version 1.0
 * on 2021/1/8
 */
@Slf4j
@Aspect
@Component
public class RedisLockAspect {

    private static ConcurrentLinkedQueue<RedisLockDefinitionHolder> holderList = new ConcurrentLinkedQueue<>();
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Pointcut("@annotation(com.lovely.redis.*)")
    public void redisLockPC() {
    }

    @Around(value = "redisLockPC()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        RedisLock annotation = method.getAnnotation(RedisLock.class);
        RedisLockTypeEnum lockTypeEnum = annotation.typeEnum();
        Object[] params = joinPoint.getArgs();
        String ukString = params[annotation.lockFiled()].toString();
        // 省略很多参数校验和判空
        String uniqueKey = lockTypeEnum.getUniqueKey(ukString);
        String uniqueValue = UUID.randomUUID().toString();

        Object res = null;

        try {
            Boolean suc = redisTemplate.opsForValue().setIfAbsent(uniqueKey, uniqueValue);
            if (suc == null || !suc) {
                throw new Exception("");
            }
            redisTemplate.expire(uniqueKey, annotation.lockTime(), TimeUnit.SECONDS);
            Thread currentThread = Thread.currentThread();
            // 将本次 Task 信息加入「延时」队列中
            holderList.add(new RedisLockDefinitionHolder(uniqueKey, annotation.lockTime(), System.currentTimeMillis(), currentThread, annotation.tryCount()));
            // 执行业务操作
            res = joinPoint.proceed();

            // 线程被中断，抛出异常
            if (currentThread.isInterrupted()) {
                throw new InterruptedException("You had been interrupted =-=");
            }
        } catch (InterruptedException e) {
            log.error("Interrupt exception, rollback transaction", e);
            throw new Exception("Interrupt exception, please send request again");
        } catch (Exception e) {
            log.error("has some error, please check again", e);
        } finally {
            // 请求结束后，强制删掉 key，释放锁
            redisTemplate.delete(uniqueKey);
            log.info("release the lock, businessKey is [" + uniqueKey + "]");
        }
        return res;

    }

    /**
     * 线程池，每个 JVM 使用一个线程去维护 keyAliveTime，定时执行 runnable
     * https://lanffy.github.io/2017/05/28/create-thread-by-threadFactory
     */
    private static final ScheduledExecutorService SCHEDULER = Executors.newScheduledThreadPool(1, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "redisLock-schedule-pool");
            t.setDaemon(true);
            return t;
        }
    });

    {
        SCHEDULER.scheduleAtFixedRate(() -> {
            // 这里记得加 try-catch，否者报错后定时任务将不会再执行
            Iterator<RedisLockDefinitionHolder> iterator = holderList.iterator();
            while (iterator.hasNext()) {
                RedisLockDefinitionHolder holder = iterator.next();
                if (holder == null) {
                    iterator.remove();
                    continue;
                }
                // 判断 key 是否还有效，无效的话进行移除
                if (redisTemplate.opsForValue().get(holder.getBusinessKey()) == null) {
                    iterator.remove();
                    continue;
                }
                // 超时重试次数，超过时给线程设定中断
                if (holder.getCurrentCount() > holder.getTryCount()) {
                    holder.getCurrentTread().interrupt();
                    iterator.remove();
                    continue;
                }
                // 判断是否进入最后三分之一时间
                long curTime = System.currentTimeMillis();
                boolean shouldExtend = (holder.getLastModifyTime() + holder.getModifyPeriod()) <= curTime;
                if (shouldExtend) {
                    holder.setLastModifyTime(curTime);
                    redisTemplate.expire(holder.getBusinessKey(), holder.getLockTime(), TimeUnit.SECONDS);
                    log.info("businessKey : [" + holder.getBusinessKey() + "], try count : " + holder.getCurrentCount());
                    holder.setCurrentCount(holder.getCurrentCount() + 1);
                }
            }
        }, 0, 2, TimeUnit.SECONDS);
    }
}
