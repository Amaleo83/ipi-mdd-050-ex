package com.ipiecoles.java.mdd050.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(
            method = RequestMethod.GET,
            produces = "text/plain",
            value = "/hello"
    )
    public String sayHello(){
        return "Hello Wolrd";
    }
}
