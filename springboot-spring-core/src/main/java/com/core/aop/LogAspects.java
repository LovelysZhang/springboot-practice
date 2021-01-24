package com.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 日志切面
 *
 * @author lovely
 * on 2021/1/24
 */
@Aspect
@EnableAspectJAutoProxy
@Configuration
public class LogAspects {


    @Pointcut("execution(public * com.core.service.impl..*.*(..))")
    public void pointCut() {

    }

    @Before("execution(* com.core.service.impl..*.*(..))")
    public void before() {
        System.out.println("");
    }

    /**
     * @param joinPoint 必须是第一个参数
     */
    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("method_" + signature.getName() + "_end");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println("method_" + joinPoint.getSignature().getName() + "_return_" + result);
    }


    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            if (joinPoint.getArgs().length == 0 || (Boolean) joinPoint.getArgs()[0]) {
                throw throwable;
            }
        }
        return result;
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        System.out.println("" + joinPoint.getSignature().getName() + "异常。。。异常信息：{" + exception + "}");
    }
}
