package com.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author lovely
 * on 2020/2/12
 */
@SpringBootApplication
@EnableAsync // 开启异步注解功能
@EnableScheduling // 开启定时任务注解
public class SpringBootTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootTaskApplication.class);
    }
}
