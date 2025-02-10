package org.example.controller;

import jakarta.annotation.PostConstruct;
import org.example.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("demo")
public class ApiController {
    @Autowired
    DemoService demoService;
    @GetMapping("DemoController")
    public String getDepositDetail(String request)
            throws Exception {
        return demoService.testLoopInjection(request);
    }



}
