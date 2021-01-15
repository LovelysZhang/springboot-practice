package com.lovely.web.controller;

import com.lovely.redis.RedisLock;
import com.lovely.redis.RedisLockTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;

/**
 * @author lovely
 * @version 1.0
 * on 2021/1/8
 */
@Slf4j
@RestController
@RequestMapping("/api/redis")
public class RedisLockController {

    @RequestMapping("/tt")
    @RedisLock(typeEnum = RedisLockTypeEnum.ONE, lockTime = 3)
    public Book testRedisLock(Long userId) {
        try {
            log.info("睡眠执行前");
            Thread.sleep(10000);
            log.info("睡眠执行后");
        } catch (Exception e) {
            // log error
            log.info("has some error", e);
        }
        return null;
    }
}
