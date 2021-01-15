package com.rabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lovely
 * on 2020/2/11
 */
@SpringBootApplication
@EnableRabbit // 开启基于注解的 RabbitMQ模式
public class SpringBootAmqpApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAmqpApplication.class);
    }
}
