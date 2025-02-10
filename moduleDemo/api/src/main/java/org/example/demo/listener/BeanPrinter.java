package org.example.demo.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
public class BeanPrinter {//implements ApplicationListener<ApplicationReadyEvent> {
//
//    @Autowired
//    ApplicationContext applicaitonContext;
//
//    @Override
//    public void onApplicationEvent(ApplicationReadyEvent event) {
//        String[] beanNames = event.getApplicationContext().getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        System.out.println("Spring Boot Loaded Beans and Methods:");
//        for (String beanName : beanNames) {
//            Object bean = event.getApplicationContext().getBean(beanName);
//            System.out.println("Bean: " + beanName + " -> " + bean.getClass().getName());
//            Arrays.stream(bean.getClass().getDeclaredMethods())
//                    .forEach(method -> System.out.println(" Method: " + method.getName()));
//        }
//    }
}
