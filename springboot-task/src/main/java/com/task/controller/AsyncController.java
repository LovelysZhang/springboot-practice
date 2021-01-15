package com.task.controller;

import com.task.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 异步任务
 *
 * @author lovely
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

    @GetMapping("/get/{id}")
    @ResponseBody
    public List<Data> getData(@PathVariable String id) {
        List<Data> list = new ArrayList<>();
        return "0".equals(id) ? null : list;
    }

    class Data {
        Integer id;
        String name;
    }
}
