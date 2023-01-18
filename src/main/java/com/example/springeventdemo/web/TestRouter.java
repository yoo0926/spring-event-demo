package com.example.springeventdemo.web;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;


@Component
public class TestRouter {
    @Bean
    public RouterFunction<ServerResponse> testRoutes(TestHandler testHandler) {
        return RouterFunctions.route(GET("/test"), testHandler::eventTest);

    }
}
