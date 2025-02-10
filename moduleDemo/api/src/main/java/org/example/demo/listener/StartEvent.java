package org.example.demo.listener;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class StartEvent implements ApplicationListener<ApplicationStartingEvent> {

    @Autowired
    ApplicationContext applicaitonContext;

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        System.out.println("start Event");

    }
}
