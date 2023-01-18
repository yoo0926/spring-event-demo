package com.example.springeventdemo.service;

import com.example.springeventdemo.event.TestEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventTestService {
    private final ApplicationEventPublisher applicationEventPublisher;

    public Mono<String> publishTest(String message) {
        return Mono.fromCallable(() -> {
            if(message != null){
                applicationEventPublisher.publishEvent(TestEvent.toCompleteEvent(message));
            } else {
                applicationEventPublisher.publishEvent(TestEvent.toErrorEvent());
            }

            return "result: " + message;
        });
    }
}
