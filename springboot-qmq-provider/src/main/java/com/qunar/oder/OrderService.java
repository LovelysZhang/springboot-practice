package com.qunar.oder;

import com.qunar.bean.QmqMessage;
import com.qunar.model.Order;
import org.springframework.stereotype.Service;
import qunar.tc.qmq.Message;
import qunar.tc.qmq.MessageSendStateListener;
import qunar.tc.qmq.producer.MessageProducerProvider;

import javax.annotation.Resource;

/**
 * @author non human
 * on 2019/11/22
 */
@Service
public class OrderService {


    public void placeOder(Order order) {
        MessageProducerProvider qmqMessage = new MessageProducerProvider();
        qmqMessage.setAppCode("hello");
        qmqMessage.setMetaServer("127.0.0.1");
        qmqMessage.init();

        //每次发消息之前请使用generateMessage生成一个Message对象，然后填充数据
        Message message = qmqMessage.generateMessage("order.changed");
        //QMQ提供的Message是key/value的形式
        message.setProperty("order",order.getOrderName());
        //发送消息
        qmqMessage.sendMessage(message, new MessageSendStateListener() {
            @Override
            public void onSuccess(Message message) {
                System.out.println("success");
            }

            @Override
            public void onFailed(Message message) {
                System.out.println("failed");
            }
        });
    }
}
