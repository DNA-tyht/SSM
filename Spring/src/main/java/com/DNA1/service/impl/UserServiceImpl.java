package com.DNA1.service.impl;

import com.DNA1.dao.UserDao;
import com.DNA1.service.UserService;

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