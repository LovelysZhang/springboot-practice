package com.amqp;

import com.rabbitmq.SpringBootAmqpApplication;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * amqp admin
 *
 * @author lovely
 * on 2020/2/11
 */

@SpringBootTest(classes = SpringBootAmqpApplication.class)
public class AmqpAdminTest {

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void createExchange() {
        // 创建 Queue、Exchange、Binding
//        amqpAdmin.declareXXX();
    }
}
