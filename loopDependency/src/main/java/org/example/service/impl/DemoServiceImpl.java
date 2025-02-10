package org.example.service.impl;

import org.example.service.DemoService;
import org.example.util.Util1;
import org.example.util.Util2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    Util1 util1;
    @Autowired
    Util2 util2;
    @Override
    public String testLoopInjection(String request) {
        String str1= util1.printMessage();

        String str2= util1.printOther();
        return String.format("%s,%s",str1,str2);
    }
}
