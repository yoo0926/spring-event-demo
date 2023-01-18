package com.example.springeventdemo.listener;

import com.example.springeventdemo.event.TestEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestEventListener {

    @EventListener
    public void handleContextStart(TestEvent event) {
        log.info("event Id: " + event.getEventId() + ", type: " + event.getType() + ", Message: " + event.getData());
        log.info("Handling context started event.");
    }
}
