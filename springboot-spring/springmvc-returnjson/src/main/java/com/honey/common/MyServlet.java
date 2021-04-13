package com.honey.common;

import com.honey.common.fiter.ServletRequestLog;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.Collections;

/**
 * @author lovely
 * @version 1.0
 * on 2021/4/13
 */
@Configuration
public class MyServlet {
    @Bean
    public FilterRegistrationBean<Filter> myFilter(){
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new ServletRequestLog());
        // 要过滤的请求
        registrationBean.setUrlPatterns(Collections.singletonList("/*"));
        return registrationBean;
    }
}
