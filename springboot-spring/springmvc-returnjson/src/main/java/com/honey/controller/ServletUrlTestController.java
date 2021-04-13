package com.honey.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试servleturl
 *
 * @author lovely
 * @version 1.0
 * on 2021/4/13
 */
@RestController
@RequestMapping("api/servlet")
public class ServletUrlTestController {

    @GetMapping("/test1")
    public void test1() {

    }

    @GetMapping("test2")
    public void test2() {

    }
}
