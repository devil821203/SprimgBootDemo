package org.example.util;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class Util2 {
    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    @Lazy
    Util1 util1;
//    @PostConstruct
//    public void init() {
//        util1=applicationContext.getBean(Util1.class);
//
//    }
    public  String printMessage(){
        System.out.println("this is Util2");
        return "this is Util2";

    }
    public  String printOther(){
        String str=util1.printMessage();
        log.info(str);
        return str;

    }

}
