package com.DNA.test;

import com.DNA.dao.UserDao;
import com.DNA.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/18 15:58
 */
public class SpringTest {
    /**
    * @Description bean的测试
    * @Return []
    * @Author 脱氧核糖
    * @Date 2021/5/18 16:32
    */
    @Test
    public void test1() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        UserDao userDao2 = (UserDao) app.getBean("userDao");
        System.out.println(userDao1);
        System.out.println(userDao2);
        app.close();
    }

    /**
    * @Description service的测试
    * @Return []
    * @Author 脱氧核糖
    * @Date 2021/5/18 16:33
    */
    @Test
    public void test2() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) app.getBean("userService");
        userService.save();
        //UserService userService = new UserServiceImpl();
        //userService.save();
    }
}
