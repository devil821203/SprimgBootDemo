    package org.example.trouble.demo.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class FailedEvent implements ApplicationListener<ApplicationFailedEvent> {

    @Autowired
    ApplicationContext applicaitonContext;

    @Override
    public void onApplicationEvent(ApplicationFailedEvent  event) {
        System.out.println("fail Event");

    }
}
