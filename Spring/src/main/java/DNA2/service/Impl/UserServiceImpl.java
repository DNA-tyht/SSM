package DNA2.service.Impl;

import DNA2.dao.UserDao;
import DNA2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/18 22:30
 */
//<bean id="userService" class="DNA2.service.Impl.UserServiceImpl">
//      <property name="userDao" ref="userDao"/>
//</bean>
//@Component("userService")
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired//自动注入，按照数据类型从Spring容器中匹配
    //@Qualifier("userDao")//按照ID的值从容器中匹配
    @Resource(name = "userDao")
    private UserDao userDao;

    @Value("cast")
    private String driver;

    //使用注解不需要set方法
    //public void setUserDao(UserDao userDao) {
    //    this.userDao = userDao;
    //}

    @Override
    public void save() {
        userDao.save();
        System.out.println(driver);
    }
}
