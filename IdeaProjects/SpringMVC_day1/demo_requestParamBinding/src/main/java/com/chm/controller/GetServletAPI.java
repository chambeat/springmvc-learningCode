package com.chm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/api")
public class GetServletAPI {

    @RequestMapping("/printInfo")
    public String printInfo(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("已执行printInfo方法");
        System.out.println(request);
        System.out.println(request.getSession());//打印Session对象
        System.out.println(request.getSession().getServletContext());//打印ServletContext对象(域对象)
        System.out.println(response);
        return "success";
    }
}
