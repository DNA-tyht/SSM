package DNA.dao;

import DNA.domain.User;

import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/25 20:22
 */
public interface UserDao {
    /**
    * @Description 查询所有的用户信息
    * @Return []
    * @Author 脱氧核糖
    * @Date 2021/5/25 20:28
    */
    public List<User> queryAllUser();

    /**
    * @Description 增加一条用户信息
    * @Return [user]
    * @Author 脱氧核糖
    * @Date 2021/5/25 21:18
    */
    Long addUser(User user);

    /**
    * @Description 增加一条关系表信息
    * @Return [id, roleIds]
    * @Author 脱氧核糖
    * @Date 2021/5/25 21:21
    */
    void addUserRole(Long userId, Long[] roleIds);

    /**
    * @Description 根据userId删除用户信息
    * @Return [userId]
    * @Author 脱氧核糖
    * @Date 2021/5/25 22:26
    */
    void deleteUserRole(Long userId);

    /**
    * @Description 根据userId删除关系表信息
    * @Return [userId]
    * @Author 脱氧核糖
    * @Date 2021/5/25 22:27
    */
    void deleteUser(Long userId);

    /**
    * @Description 根据用户名和密码查询用户信息
    * @Return [username, password]
    * @Author 脱氧核糖
    * @Date 2021/5/25 22:27
    */
    User queryUsernameAndPassword(String username, String password);
}
