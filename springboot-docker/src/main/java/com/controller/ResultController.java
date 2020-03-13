package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author non human
 * on 2020/3/13
 */
@RestController
public class ResultController {

    @RequestMapping("/ping")
    public String ping() {
        return "pong";
    }
}
