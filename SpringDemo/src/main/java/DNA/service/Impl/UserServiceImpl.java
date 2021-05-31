package DNA.service.Impl;

import DNA.mapper.RoleDao;
import DNA.mapper.UserDao;
import DNA.domain.Role;
import DNA.domain.User;
import DNA.service.UserService;

import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/25 20:23
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private RoleDao roleDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<User> queryAllUser() {
        List<User> userList = userDao.queryAllUser();
        for (User user : userList) {
            Long id = user.getId();
            List<Role> roles = roleDao.queryRoleByUserId(id);
            user.setRoles(roles);
        }
        return userList;
    }

    @Override
    public void addUser(User user, Long[] roleIds) {
        Long userId = userDao.addUser(user);
        userDao.addUserRole(userId, roleIds);
    }

    @Override
    public void deleteUserById(Long userId) {
        userDao.deleteUserRole(userId);
        userDao.deleteUser(userId);
    }

    @Override
    public User login(String username, String password) {
        return userDao.queryUsernameAndPassword(username, password);
    }
}
