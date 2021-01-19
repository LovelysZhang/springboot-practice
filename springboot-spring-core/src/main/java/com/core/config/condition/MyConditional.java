package com.core.config.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author lovely
 * @version 1.0
 * on 2021/1/19
 */
public class MyConditional implements Condition {

    /**
     * @param context  判断条件能使用的上下文（环境）
     * @param metadata 注释信息
     * @return 判断条件是否匹配
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //1、能获取到ioc使用的beanfactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //2、获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        //3、获取当前环境信息
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");

        //4、获取到bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        //可以判断容器中的bean注册情况，也可以给容器中注册bean
        if (registry.containsBeanDefinition("person")) {
            System.out.println("ioc中注册了bean with name person");
        }
        return true;
    }
}
