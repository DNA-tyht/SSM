package DNA1.service.impl;

import DNA1.service.UserService;
import DNA1.dao.UserDao;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        userDao.save();
    }
}
