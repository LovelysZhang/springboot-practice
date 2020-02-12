package com.task.controller;

import com.task.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异步任务
 * @author non human
 * on 2020/2/12
 */
@RestController
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/say")
    public void say() {
        asyncService.asyncHello();
    }
}
