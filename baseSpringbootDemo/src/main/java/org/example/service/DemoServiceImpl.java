package org.example.service;

import org.example.util.Util1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String getMessage(String request) {
        String str1="Hello world!";
        return str1;
    }
}
