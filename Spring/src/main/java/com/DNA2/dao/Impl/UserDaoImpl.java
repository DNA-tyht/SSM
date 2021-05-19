package com.DNA2.dao.Impl;

import com.DNA2.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/18 22:30
 */
//<bean id="userDao" class="com.DNA2.dao.Impl.UserDaoImpl"/>
//@Component("userDao")
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("UserDao save running");
    }

    @PostConstruct
    public void init() {
        System.out.println("UserDao init running");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("UserDao destroy running");
    }
}
