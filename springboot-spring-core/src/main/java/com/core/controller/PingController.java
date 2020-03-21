package com.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author non human
 * on 2019/10/1
 */
@Controller
public class PingController {

    @GetMapping("/ping")
    @ResponseBody
    public String ping() {
        return "pong";
    }

    @GetMapping("index2")
    public String index() {
        return "index.html";
    }
}
