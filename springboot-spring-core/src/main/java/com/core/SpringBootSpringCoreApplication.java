package com.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lovely
 * on 2020/3/19
 * @Configuration:指明当前类是一个配置类，用来代替@ImportResource的注解和Spring的配置文件
 */
@SpringBootApplication
//@Import(MyWebConfig.class)
public class SpringBootSpringCoreApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringBootSpringCoreApplication.class);
        SpringApplication.run(SpringBootSpringCoreApplication.class);
    }
}
