package com.chm.controller;

import com.chm.domain.Account;
import com.chm.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/saveAccount")
    public String saveAccount(Account account) {
        System.out.println("已执行saveAccount方法");
        System.out.println(account);
        return "success";
    }

    @RequestMapping("/saveUser")
    public String saveUser(User user) {
        System.out.println("已执行saveUser方法");
        System.out.println(user);
        return "success";
    }
}
