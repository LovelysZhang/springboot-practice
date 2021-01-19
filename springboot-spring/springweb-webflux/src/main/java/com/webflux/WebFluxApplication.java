package com.webflux;

import com.webflux.service.GreetingWebClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lovely
 * @version 1.0
 * on 2021/1/18
 */
@SpringBootApplication
public class WebFluxApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebFluxApplication.class);

        GreetingWebClient client = new GreetingWebClient();
        System.out.println(client.getResult());

    }
}
