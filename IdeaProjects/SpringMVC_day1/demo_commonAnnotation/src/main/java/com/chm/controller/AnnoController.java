package com.chm.controller;

import com.chm.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"}) //把'msg=哈哈'存入session域对象中，即request对象和session对象中都有msg。
public class AnnoController {

    /**
     * RequestBody 注解
     * @param body
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("testRequestBody执行了");
        System.out.println(body);
        return "success";
    }

    /**
     * PathVariable 注解  （该注解体现了RESTful风格）
     * @param id
     * @return
     */
    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(value = "sid") String id) {
        System.out.println("testPathVariable执行了");
        System.out.println(id);
        return "success";
    }

    /**
     * （了解即可）RequestHeader 注解
     * @param header
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header) {
        System.out.println("testRequestHeader执行了");
        System.out.println(header);
        return "success";
    }

    /**
     * （了解即可）CookieValue 注解
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue) {
        System.out.println("testCookieValue执行了");
        System.out.println(cookieValue);
        return "success";
    }

    /**
     * ModelAttribute 注解（Part 1）
     * @param user
     * @return
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("user_1") User user) {
        System.out.println("testModelAttribute执行了");
        System.out.println(user);
        return "success";
    }

    /**
     * ModelAttribute 注解（Part 2）
     * @param uname
     * @param map
     */
    @ModelAttribute
    public void showUser(String uname, Map<String, User> map) {// 应用场景2：作用于无返回值的方法
        System.out.println("showUser执行了");
        // (模拟)通过用户名查询数据库
        User user = new User();
        user.setUname(uname);//表单获取
        user.setAge(23);//表单获取
        user.setDate(new Date());//从数据库获取(因为表单没有提供)
        map.put("user_1", user);
    }

/*
    @ModelAttribute
    public User showUser(String uname) {// 应用场景1：作用于有返回值的方法
        System.out.println("showUser执行了");
        // (模拟)通过用户名查询数据库
        User user = new User();
        user.setUname(uname);//表单获取
        user.setAge(23);//表单获取
        user.setDate(new Date());//从数据库获取(因为表单没有提供)
        return user;
    }
*/

    /**
     * SessionAttributes 注解  （注意：该注解只能用在类上，不能作用于方法上。）
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model) {                      //存入值
        System.out.println("testSessionAttributes执行了");
        model.addAttribute("msg", "哈哈");//底层做的事情：会将'msg=哈哈'存储到request域对象中
        return "success";
    }

    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap) {                 //获取值
        System.out.println("getSessionAttributes执行了");
        Object msg = modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    @RequestMapping("/removeSessionAttributes")
    public String removeSessionAttributes(SessionStatus sessionStatus) {    //删除值
        System.out.println("removeSessionAttributes执行了");
        sessionStatus.setComplete();
        return "success";
    }
}
