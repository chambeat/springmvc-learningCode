package com.chm.controller;

import com.chm.domain.Account;
import com.chm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 账户的表现层类
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    /**
     * 查询所有账户
     */
    @RequestMapping("/findAll")
    public String findAll(Model model) {
        System.out.println("表现层：查询所有账户");
        //调用service中的方法
        List<Account> accounts = accountService.findAll();
        //将查询结果存入model对象中
        model.addAttribute("accounts", accounts);
        return "list";
    }

    /**
     * 保存账户
     */
    @RequestMapping("/saveAccount")
    public void saveAccount(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("表现层：保存账户");
        //调用service中的方法
        accountService.saveAccount(account);
        //重定向到查询所有
        response.sendRedirect(request.getContextPath() + "/account/findAll");
//        return "list";
    }
}
