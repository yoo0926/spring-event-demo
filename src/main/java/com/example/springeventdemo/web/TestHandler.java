package com.example.springeventdemo.web;

import com.example.springeventdemo.service.EventTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class TestHandler {
    private final EventTestService eventTestService;

    public Mono<ServerResponse> eventTest(ServerRequest serverRequest) {
        String message = serverRequest.queryParam("param").orElse(null);
        return ServerResponse.ok()
                .body(eventTestService.publishTest(message), String.class);
    }
}
