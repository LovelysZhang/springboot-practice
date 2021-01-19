package com.webflux.web.controller;

import com.webflux.service.GreetingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author lovely
 * @version 1.0
 * on 2021/1/18
 */
@Configuration
public class GeetingRouter {

    /**
     * The router listens for traffic on the /hello path and returns the value provided by our reactive handler class.
     * @param greetingHandler
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/hello")
                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), greetingHandler::hello);
    }

}
