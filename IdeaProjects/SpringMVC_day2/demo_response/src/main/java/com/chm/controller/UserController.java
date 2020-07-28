package com.chm.controller;

import com.chm.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    /*@RequestMapping("/testString")
    public String testString() {
        System.out.println("testString方法执行了");
        return "success";
    }*/

    /*
     * 返回值是String
     */
    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println("testString方法执行了");
        //模拟从数据库中查询User对象
        User user = new User();
        user.setUsername("婷婷");
        user.setPassword("chm");
        user.setAge(20);
        //将查询到的User对象存入Model对象中
        model.addAttribute("user", user);
        return "success";
    }

    /*
     * 返回值是void
     *  注意：只有请求转发(forward)能直接访问WEB-INF目录下的资源，重定向(redirect)因权限不够故无法访问。
     *      （根本原因：Tomcat对不同的资源跳转方式设置了不同的访问权限）
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid方法执行了");
        //跳转方式：请求转发
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
        //跳转方式：重定向
//        response.sendRedirect(request.getContextPath() + "/index.jsp");

        //直接进行响应，不跳转到任何jsp页面
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("你好（这是一次直接响应）");
    }

    /**
     * 返回值是ModelAndView类型
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println("testModelAndView方法执行了");

        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        //模拟从数据库中查询User对象
        User user = new User();
        user.setUsername("二哥");
        user.setPassword("chm");
        user.setAge(43);

        //把user对象存储到mv对象中，同时mv对象会把user对象存入到request域对象中(因为mv对象底层用的是ModelMap对象)
        mv.addObject("user", user);
        //指定要跳转的页面
        mv.setViewName("success");//执行此语句时，会调用视图解析器

        return mv;
    }

    /**
     * 使用关键字的方式进行转发或重定向
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect() {
        System.out.println("testForwardOrRedirect方法执行了");
        //1.请求转发
//        return "forward:/WEB-INF/pages/success.jsp";
        //2.重定向
        return "redirect:/index.jsp";
    }

    /*
     * 模拟异步请求响应
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println("testAjax方法执行了");
        //客户端发送ajax请求，传的是json字符串，后端把json字符串封装到User对象中
        System.out.println(user);
        //作出响应，模拟查询数据库
        user.setUsername("哈哈AJAX");
        user.setAge(40);
        return user;
    }
}
