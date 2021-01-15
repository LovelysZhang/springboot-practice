package com.core.service;

import com.core.BaseTest;
import org.junit.jupiter.api.Test;


import javax.annotation.Resource;



public class TestServiceTest extends BaseTest {

    @Resource
    private TestService testService;

    @Test
    public void test1() {
        testService.test();
    }
}