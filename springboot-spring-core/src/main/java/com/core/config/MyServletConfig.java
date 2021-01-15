package com.core.config;

import com.core.servlet.MyServlet;
import com.core.servlet.filter.MyFilter;
import com.core.servlet.listener.MyListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import java.util.Arrays;
import java.util.EventListener;

/**
 * servlet三大组件注册和配置
 *
 * @author lovely
 * on 2020/3/26
 */
@Configuration
public class MyServletConfig {

    //注册三大组件
    @Bean
    public ServletRegistrationBean<Servlet> myServlet(){
        // 请求映射的路径就可以访问自定义的servlet
        // 拦截器只会处理DispatcherServlet处理的url，访问/myServlet时，自定义的Servlet处理了请求，此时拦截器不处理
        // 参考：https://www.cnblogs.com/mr-yang-localhost/p/7784607.html#_lab6
        ServletRegistrationBean<Servlet> registrationBean = new ServletRegistrationBean<>(new MyServlet(),"/myServlet");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<Filter> myFilter(){
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new MyFilter());
        // 要过滤的请求
        registrationBean.setUrlPatterns(Arrays.asList("/index2","/myServlet"));
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<EventListener> myListener(){
        ServletListenerRegistrationBean<EventListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return registrationBean;
    }
}
