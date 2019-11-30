package com.qunar;

import com.qunar.model.Order;
import com.qunar.oder.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * @author non human
 * on 2019/11/22
 */
@SpringBootApplication
public class ProviderApplication implements CommandLineRunner{
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class);
    }

    @Resource
    private OrderService orderService;

    @Override
    public void run(String... args) throws Exception {
        Order order = new Order();
        order.setOrderName("hhh");
        orderService.placeOder(order);
    }

}
