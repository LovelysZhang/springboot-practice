package com.kafka.amqp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * kafka消费者
 *
 * @author lovely
 * on 2020/10/26
 */
@Slf4j
@Component
public class KafkaListenerDemo {

    @KafkaListener(topics = "topic1", containerFactory = "myKafkaFactory")
    public void onMessage(String message) {
        log.info("message={}", message);
    }
}
