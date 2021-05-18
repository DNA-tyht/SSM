package com.DNA.service.impl;

import com.DNA.dao.Impl.UserDaoImpl;
import com.DNA.dao.UserDao;
import com.DNA.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/18 16:29
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        userDao.save();
    }

    //public void setUserDao(UserDaoImpl userDao) {
    //    this.userDao = userDao;
    //}
}
