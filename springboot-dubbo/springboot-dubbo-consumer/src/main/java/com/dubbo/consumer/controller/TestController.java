package com.dubbo.consumer.controller;

import com.dubbo.consumer.service.UserService;
import com.google.common.collect.Range;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;


/**
 * @author non human
 * on 2020/2/13
 */
@RestController
public class TestController {
    @Resource
    UserService userService;

    @GetMapping("/ticket")
    @ResponseBody
    public int test() {
        userService.bugTicket();
        return new Random().nextInt(1000);
    }
}
