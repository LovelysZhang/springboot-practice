package com.webflux.service;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author lovely
 * @version 1.0
 * on 2021/1/18
 */
public class GreetingWebClient {
    private WebClient client = WebClient.builder()
            .baseUrl("http://localhost:8080").build();


    private Mono<ClientResponse> result = client.get()
            .uri("hello")
            .accept(MediaType.TEXT_PLAIN)
            .exchange();

    public String getResult() {
        return ">> result = " + result.flatMap(res -> res.bodyToMono(String.class)).block();
    }

}
