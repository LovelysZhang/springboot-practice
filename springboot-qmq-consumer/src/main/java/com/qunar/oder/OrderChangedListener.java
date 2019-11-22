package com.qunar.oder;

import org.springframework.stereotype.Service;
import qunar.tc.qmq.Message;
import qunar.tc.qmq.consumer.annotation.QmqConsumer;

/**
 * @author non human
 * on 2019/11/22
 */
@Service
public class OrderChangedListener {
    @QmqConsumer(subject = "", consumerGroup = "", executor = "")
    public void onMessage(Message message) {
        String orderName = message.getStringProperty("name");
    }
}
