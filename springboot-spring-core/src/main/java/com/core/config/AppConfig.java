package com.core.config;

import com.core.component.MyComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 项目配置类
 *
 * @author lovely
 * on 2020/3/27
 * <code>@Configuration</code>指明当前类是一个配置类，代替@ImportResource的注解和Spring的配置文件
 * 在xml配置文件中用<bean><bean/>
 */
@Configuration
@Slf4j
public class AppConfig {
    @Bean
    public MyComponent initComponent() {
        log.info("配置类通过@Bean给容器添加了组件");
        return new MyComponent();
    }
}
