package com.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Spring cloud 是通过轻量级 http 进行通信
 *
 * @author lovely
 * on 2020/2/14
 */
@RestController
public class ConsumeController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/get")
    public String bugTicket(String name) {
        // 访问localhost:8761中注册的服务的服务名：PROVIDER-TICKET，访问PROVIDER-TICKET服务的路由地址 /ticket
        // 获取电影票并转成字符串
        String s = restTemplate.getForObject("http://PROVIDER-TICKET/ticket", String.class);
        return name + "购买了" + s;
    }
}
