package com.core;

import com.core.interceptor.MyWebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author non human
 * on 2020/3/19
 */
@SpringBootApplication
@Import(MyWebConfig.class)
public class SpringBootSpringCoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootSpringCoreApplication.class);
    }
}
