package DNA.factory;

import DNA.mapper.Impl.UserDaoImpl;
import DNA.mapper.UserDao;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/18 16:25
 */
public class DynamicFactory {

    public UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
