package com.core.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 使用FactoryBean注入bean
 *
 * @author hello.z
 * on 2021/1/19
 */
public class MyColorFactoryBean implements FactoryBean<Color> {

    /**
     * @return 是否是单例模式
     */
    @Override
    public boolean isSingleton() {
        return true;
    }

    /**
     * @return 返回一个Color对象，这个对象会添加到容器中
     * @throws Exception
     */
    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean...getObject...");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }
}
