package com.core.service.impl;

import com.core.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hj.Z
 * on 2020/7/17
 */
@Service
public class HelloService implements TestService {

    private DefaultService defaultService;

    public HelloService() {
        this.defaultService = new DefaultService();
    }

    @Override
    public void test() {
        System.out.println(getClass().getName());
        defaultService.test();
    }
}
