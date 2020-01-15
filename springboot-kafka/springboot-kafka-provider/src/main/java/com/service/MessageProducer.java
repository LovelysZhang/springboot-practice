package com.service;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

/**
 * @author non human
 * on 2020/1/3
 */
@Service
public class MessageProducer {

    @Resource
    private KafkaTemplate<String, String> template;

    public void sendOne() {
        // 键和值对象的类型必须与序列化器和生产者对象相匹配。
        ProducerRecord<String, String> record =
                new ProducerRecord<>("CustomerCountry", "Precision Product", "France");
        // 异步发送
        template.send(record);
    }

    /**
     * 同步发送消息
     */
    public void syncSendOne() {
        ProducerRecord<String, String> record =
                new ProducerRecord<>("CustomerCountry", "Precision Product", "France");
        try {
            // send() 方法先返回一个Future 对象，然后调用Future 对象的get()方法等待Kafka 响应。
            template.send(record).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    // 大多数时候，我们并不需要等待响应——尽管Kafka会把目标主题、分区信息和消息的偏移量发送回来，
    // 但对于发送端的应用程序来说不是必需的。不过在遇到消息发送失败时，我们需要抛出异常、记录错误日志，
    // 或者把消息写入“错误消息”文件以便日后分析。
    private class ProducerCallback implements Callback {

        @Override
        public void onCompletion(RecordMetadata recordMetadata, Exception e) {
            if (e != null) {
                e.printStackTrace();
            }
        }
    }

    public void asyncSendOne() {
//        KafkaProducer kafkaProducer = new KafkaProducer<String, String>();
        ProducerRecord<String, String> record =
                new ProducerRecord<>("CustomerCountry", "Precision Product", "France");
        // send() 方法先返回一个Future 对象，然后调用Future 对象的get()方法等待Kafka 响应。
//        template.send(record,new ProducerCallback());
    }
}
