package com.rabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author lovely
 * on 2020/2/11
 */
@Service
public class BookNewsService {

    @RabbitListener(queues = "AA.news")
    public void receiveRabbitMessage(Object msg) {
        // 监听到消息队列 AA.new 有消息队列中有消息，打印消息
        System.out.println(msg);
    }
}
