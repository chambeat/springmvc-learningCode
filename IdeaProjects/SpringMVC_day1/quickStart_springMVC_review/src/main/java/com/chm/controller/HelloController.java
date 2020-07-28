package com.chm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println("Hello SpringMVC!");
        return "success";
    }

    @RequestMapping("/requestMapping")
    public String sayRequestMapping() {
        System.out.println("Hello RequestMapping!");
        return "success_RequestMapping";
    }
}
