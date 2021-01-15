package com.task.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 异步操作
 *
 * @author lovely
 * on 2020/2/12
 */
@Service
@Slf4j
public class AsyncService {

    /**
     * @Async 这是一个异步方法
     */
    @Async
    public void asyncHello() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("任务处理中......");
    }
}
