package com.core.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 监听器
 *
 * @author non human
 * on 2019/2/6
 */
public class MyListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized-----web项目启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed-----当前web项目销毁");
    }
}
