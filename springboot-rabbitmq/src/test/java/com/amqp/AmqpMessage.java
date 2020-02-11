package com.amqp;

import com.rabbitmq.SpringBootAmqpApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 改进的消息队列协议
 * rabbitMQ
 * @author non human
 * on 2020/2/11
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootAmqpApplication.class)
public class AmqpMessage {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 点对点
     */
    @Test
    public void SendDirect() {
        // 需要自己定义一個Message
        // 定义消息体内容和消息头
        // Object默认当成消息体，只需要传入发送的对象，自动序列化发送给rabbitmq
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "this is a message");
        map.put("data", Arrays.asList("hello", 123, true));
        // 对象被默认序列化后发送出去
        rabbitTemplate.convertAndSend("exchange.direct", "AA", map);
    }

    /**
     * 简单接收消息
     */
    @Test
    public void receiveMessage() {
        Object msg = rabbitTemplate.receiveAndConvert("AA");
        System.out.println(msg.getClass());
        System.out.println(msg);
    }

    /**
     * 广播消息
     */
    @Test
    public void fanoutMessage() {
        // 广播不需要routingKey
        rabbitTemplate.convertAndSend("exchange.fanout", "", Arrays.asList("1111", 2, false));
    }
}
