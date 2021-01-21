package com.core.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * 自定义ApplicationContextAware相关组件
 *
 * @author lovely
 * on 2021/1/22
 */
@Component
public class MyColorComponent implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        System.out.println("传入的ioc=" + applicationContext);
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanName(final String name) {
        System.out.println("当前bean的名字" + name);
    }

    @Override
    public void setEmbeddedValueResolver(final StringValueResolver resolver) {
        String resolved = resolver.resolveStringValue("hello ${os.name}. 1+1=#{1+1}");
        System.out.println(resolved);
    }
}
