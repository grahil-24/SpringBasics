package org.example.springbootmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//indicates that all methods return data and not view
@RestController
public class HelloController {

    @GetMapping("/hello")
    //responsebody means we are not sending a view, but sending data in response.Its annoying
    //and repetitive to use this annotation on every method. So we can use RestController
    @ResponseBody
    public String hello() {
        return "hello!";
    }

    @GetMapping("/ciao")
    public String ciao() {
        return "ciao!";
    }

}
