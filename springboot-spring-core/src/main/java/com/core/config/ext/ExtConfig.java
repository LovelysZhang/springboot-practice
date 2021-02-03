package com.core.config.ext;

import com.core.bean.Blue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lovely
 * on 2021/1/28
 */
@Configuration
public class ExtConfig {
    @Bean
    public Blue blue() {
        return new Blue();
    }
}
