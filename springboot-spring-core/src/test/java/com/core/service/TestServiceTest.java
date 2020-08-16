package com.core.service;

import com.core.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

public class TestServiceTest extends BaseTest {

    @Resource
    private TestService testService;

    @Test
    public void test1() {
        testService.test();
    }
}