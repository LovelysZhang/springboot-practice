package com.core.service.impl;

import com.core.service.TestService;

/**
 * @author lovely
 * on 2020/7/17
 */
public class DefaultService implements TestService {
    @Override
    public void test() {
        System.out.println(getClass().getName());
    }
}
