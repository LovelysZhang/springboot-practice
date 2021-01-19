package com.core.config;

import com.core.bean.Person;
import com.core.config.condition.MyConditional;
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

    @Bean("person")
    @Conditional(MyConditional.class)
    public Person getPerson() {
        Environment environment = applicationContext.getEnvironment();
        String os = environment.getProperty("os.name");
        System.out.println(os);

        // 打印所有bean
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (final String definitionName : definitionNames) {
            System.out.println("-->" + definitionName);
        }

        // FactoryBean
        Object bean1 = applicationContext.getBean("myColorFactoryBean");
        Object bean2 = applicationContext.getBean("&myColorFactoryBean");
        // bean1 = com.core.bean.Color@241a53ef
        System.out.println("bean1 = " + bean1);
        // bean2 = com.core.bean.MyColorFactoryBean@344344fa
        System.out.println("bean2 = " + bean2);
        return new Person();
    }
}
