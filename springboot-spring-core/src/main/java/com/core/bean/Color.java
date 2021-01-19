package com.core.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author hello.z
 * on 2021/1/19
 */
public class Color implements ApplicationContextAware {

    ApplicationContext applicationContext;

    /**
     * 给组件set容器,其他方法就可以直接使用IOC容器
     * 功能的实现类 {@link org.springframework.context.support.ApplicationContextAwareProcessor}
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
