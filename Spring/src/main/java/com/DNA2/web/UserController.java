package com.DNA2.web;

import com.DNA2.config.SpringConfiguration;
import com.DNA2.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description 假设的web层
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/18 22:38
 */

public class UserController {
    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService = (UserService)app.getBean(UserService.class);
        userService.save();
    }
}
