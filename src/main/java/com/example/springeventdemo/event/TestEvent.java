package com.example.springeventdemo.event;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class TestEvent {
    private String eventId;
    private String type;
    private String data;

    public static TestEvent toCompleteEvent(String data){
        return TestEvent.builder()
                .eventId(UUID.randomUUID().toString())
                .type("completed")
                .data(data)
                .build();
    }

    public static TestEvent toErrorEvent(){
        return TestEvent.builder()
                .eventId(UUID.randomUUID().toString())
                .type("error")
                .data("data is Null")
                .build();
    }
}
