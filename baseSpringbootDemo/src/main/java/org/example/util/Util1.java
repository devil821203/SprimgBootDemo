package org.example.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Util1 {

    public  String printMessage(){
        String str="this is Util1";
        log.info(str);
        return str;
    }


}
