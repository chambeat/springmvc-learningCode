package com.chm.test;

import com.chm.dao.AccountDao;
import com.chm.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    /**
     * 测试查询所有
     */
    @Test
    public void test1() throws Exception {
        //1.加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.创建SqlSession对象
        SqlSession session = factory.openSession();
        //4.获取代理对象
        AccountDao accountDao = session.getMapper(AccountDao.class);
        //5.使用代理对象执行方法
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
        //6.释放资源
        session.close();
        in.close();
    }

    /**
     * 测试保存
     */
    @Test
    public void test2() throws Exception {
        Account account = new Account();
        account.setName("超人");
        account.setMoney(1000D);
        //1.加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.创建SqlSession对象
        SqlSession session = factory.openSession();
        //4.获取代理对象
        AccountDao accountDao = session.getMapper(AccountDao.class);
        //5.1 使用代理对象执行方法
        accountDao.saveAccount(account);
        //5.2 提交事务(增删改需要)
        session.commit();
        //6.释放资源
        session.close();
        in.close();
    }
}
