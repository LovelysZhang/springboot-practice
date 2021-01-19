package com.core.config;

import com.core.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Spring常见类demo
 *
 * @author lovely
 * @version 1.0
 * on 2021/1/19
 */
@Configuration
public class SpringCommonClassDemo {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    @Conditional(MyConditional.class)
    public Person getPerson() {
        Environment environment = applicationContext.getEnvironment();
        String os = environment.getProperty("os.name");
        System.out.println(os);

        return new Person();
    }
}
