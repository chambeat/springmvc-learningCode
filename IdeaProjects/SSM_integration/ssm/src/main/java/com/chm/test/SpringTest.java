package com.chm.test;

import com.chm.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试 Spring 框架是否配置成功
 */
public class SpringTest {

    @Test
    public void test1() {
        //1.加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获取对象
        AccountService as = ac.getBean("accountService", AccountService.class);

        //调用对象中的方法
        as.findAll();
    }
}
