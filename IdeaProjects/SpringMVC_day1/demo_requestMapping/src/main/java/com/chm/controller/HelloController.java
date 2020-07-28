package com.chm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println("Hello SpringMVC!");
        return "success";
    }

    @RequestMapping(value = "/testRequestMapping", method = {RequestMethod.GET, RequestMethod.POST})
    public String sayRequestMapping() {
        System.out.println("This is RequestMapping!");
        return "successRequestMapping";
    }
}
