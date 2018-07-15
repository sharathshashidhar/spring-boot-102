package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sshashidhar on 3/19/18.
 */
@RestController
@RequestMapping("/api")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET, value="/hello")
    public String getHello(){
        return "Hello from Spring-boot";
    }

}
