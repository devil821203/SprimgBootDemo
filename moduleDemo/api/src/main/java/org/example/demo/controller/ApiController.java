package org.example.demo.controller;

import org.example.trouble.demo.CoreDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api", produces = "application/json;charset=UTF-8")
public class ApiController {
@Autowired
CoreDemo core;

//    @Autowired
//    RedisTemplate<String, String> redisTemplate;
     @GetMapping("/demo")
    public String  postAnnouncement() throws Exception {



         return core.getMessage();
//        return core.getMessage();



    }

}
