package com.qunar.oder;

import com.qunar.bean.QmqMessage;
import com.qunar.model.Order;
import org.springframework.stereotype.Service;
import qunar.tc.qmq.Message;
import qunar.tc.qmq.MessageProducer;

import javax.annotation.Resource;

/**
 * @author non human
 * on 2019/11/22
 */
@Service
public class OderService {

    @Resource
    private QmqMessage producer;

    public void placeOder(Order order) {
        Message message = producer.generateMessage("order.changed");
        message.setProperty("orderId",order.getName());
        producer.sendMessage(message);
    }
}
