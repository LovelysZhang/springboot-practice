package com.webflux.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author lovely
 * @version 1.0
 * on 2021/1/18
 */
@Component
public class GreetingHandler {

    private final AtomicLong counter = new AtomicLong();

    /**
     * hand request and create a response
     * @param request
     * @return
     */
    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Hello, Spring!"));

    }

}
