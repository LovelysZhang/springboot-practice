package com.core.controller;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    private ImmutableMap<String, piece> map;

    @GetMapping("get")
    public void test2() {
        List<piece> integratedConfList = Lists.newArrayList();


        for (int i = 0; i < 10; i++) {
            integratedConfList.add(new piece().setId(System.currentTimeMillis() + "" + i));
        }
        map = Maps.uniqueIndex(integratedConfList, piece::getId);
        map.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + "-----" + entry.getValue());
        });
    }

    public class piece {
        String id;

        public String getId() {
            return id;
        }

        public piece setId(String id) {
            this.id = id;
            return this;
        }
    }
}
