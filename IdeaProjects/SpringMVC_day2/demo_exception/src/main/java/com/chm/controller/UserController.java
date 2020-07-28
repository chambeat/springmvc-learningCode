package com.chm.controller;

import com.chm.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testException")
    public String testException() throws Exception {
        System.out.println("testException执行了");

        try {
            //模拟异常
            int a = 10 / 0;
        } catch (Exception e) {
            //打印异常信息
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("执行请求期间发生错误！");
        }

        return "success";
    }
}
