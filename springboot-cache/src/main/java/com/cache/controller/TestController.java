package com.cache.controller;

import com.cache.dao.UserInfoDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author non human
 * on 2019/10/1
 */
@RestController
public class TestController {

    @Resource
    private UserInfoDao userInfoDao;

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello world";
    }

    @GetMapping("/ping")
    @ResponseBody
    public int through() {
        return userInfoDao.total();
    }
}
