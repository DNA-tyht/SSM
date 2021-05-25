package DNA.service;

import DNA.domain.User;

import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/25 20:23
 */
public interface UserService {
    /**
    * @Description 查询所有的用户信息
    * @Return []
    * @Author 脱氧核糖
    * @Date 2021/5/25 20:26
    */
    public List<User> queryAllUser();

    /**
    * @Description 增加一条用户信息
    * @Return [user, roleIds]
    * @Author 脱氧核糖
    * @Date 2021/5/25 21:16
    */
    void addUser(User user, Long[] roleIds);

    /**
    * @Description 根据userId删除一条用户信息
    * @Return [userId]
    * @Author 脱氧核糖
    * @Date 2021/5/25 21:54
    */
    void deleteUserById(Long userId);

    /**
    * @Description 登录
    * @Return [username, password]
    * @Author 脱氧核糖
    * @Date 2021/5/25 22:24
    */
    User login(String username, String password);
}
