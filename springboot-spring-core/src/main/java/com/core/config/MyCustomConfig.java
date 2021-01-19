package com.core.config;

import com.core.bean.MyColorFactoryBean;
import com.core.bean.MyImportSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author hello.z
 * on 2021/1/19
 */
@Configuration
@Import({MyImportSelector.class})
public class MyCustomConfig {

    @Bean
    public MyColorFactoryBean myColorFactoryBean() {
        return new MyColorFactoryBean();
    }
}
