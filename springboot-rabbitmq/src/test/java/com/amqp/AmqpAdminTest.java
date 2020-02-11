package com.amqp;

import com.rabbitmq.SpringBootAmqpApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * amqp admin
 *
 * @author non human
 * on 2020/2/11
 */
@RunWith(SpringRunner.class)
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
