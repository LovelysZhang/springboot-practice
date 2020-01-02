package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author non human
 * on 2020/1/1
 */
@RestController
public class SampleController {
    @Autowired
    private KafkaTemplate<String, String> template;

    @GetMapping("/send")
    @ResponseBody
    String send(String topic, String key, String data) {
        template.send(topic, key, data);
        return "success";
    }

}
