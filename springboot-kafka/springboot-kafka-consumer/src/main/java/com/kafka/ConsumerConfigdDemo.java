package com.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Properties;

/**
 * @author non human
 * on 2020/1/15
 */
@Slf4j
public class ConsumerConfigdDemo {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("group.id", "CountryCounter");
        // 假设键-值都是字符串类型
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        // 接受一个主题列表作为参数
        // 主题支持正则表达式，匹配多个主题
        consumer.subscribe(Collections.singletonList("customerCountries"));
        HashMap<String, Integer> hashMap = new HashMap<>();
        try {
            while (true) {
                // 消费者持续对kafka进行轮训，否则会被认为已经死亡
                // 在消费者的缓冲区里没有可用数据时会发生阻塞等待，超时就会把控制权还给执行轮训的线程
                // 参数为0，poll方法立即返回
                ConsumerRecords<String, String> records = consumer.poll(100);
                records.forEach(record -> {
                    log.debug("topic:>>{}, partition>>{}, offset>>{}, key:>>{}, value:>>{}", record.topic(), record.partition(), record.offset(), record.key(), record.value());
                    int updateCount = 1;
                    if (hashMap.containsValue(record.value())) {
                        updateCount = hashMap.get(record.value()) + 1;
                    }
                    hashMap.put(record.value(), updateCount);
                    System.out.println(hashMap.toString());
                });
            }
        } finally {
            // 关闭消费者，网络连接和socket也会随之关闭，并立即触发一次再均衡
            // 而不是等待群组协调器发现他不再发送心跳并认定它已经死亡。因为那样
            // 需要更长的时间，导致整个群组在一段时间内无法读取消息。
            consumer.close();
        }
    }
}
