package org.example.util;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Util1 {

    @Autowired
    @Lazy
    Util2 util2;

    @Autowired
    ApplicationContext applicationContext;

//    @PostConstruct
//    public void init() {
//        util2=applicationContext.getBean(Util2.class);
//
//    }

    public  String printMessage(){
        String str="this is Util1";
        log.info(str);
        return str;
    }
    public  String printOther(){
        String str=util2.printMessage();
        log.info(str);
        return str;

    }

}
