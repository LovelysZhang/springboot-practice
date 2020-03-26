package com.core.config;

import com.core.servlet.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author non human
 * on 2020/3/19
 */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    /**
     * 添加静态资源文件映射，外部可以通过地址直接访问
     * 除此之外，还需要在maven中配置文件拷贝
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("/");
    }

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**")
                // 排除拦截的请求，可在控制台看见没有拦截日志输出
                .excludePathPatterns("/", "/healthcheck.html", "/static/**", "/*.html");
    }
}
