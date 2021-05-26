package DNA.dao.Impl;

import DNA.dao.UserDao;
import DNA.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/18 15:45
 */
public class UserDaoImpl implements UserDao {
    private List<String> strList;
    private Map<String, User> userMap;
    private Properties properties;

    public UserDaoImpl() {
        System.out.println("构造方法");
    }

    public UserDaoImpl(List<String> strList, Map<String, User> userMap, Properties properties) {
        this.strList = strList;
        this.userMap = userMap;
        this.properties = properties;
    }

    public List<String> getStrList() {
        return strList;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void save() {
        System.out.println(strList);
        System.out.println(userMap);
        System.out.println(properties);
        System.out.println("Save running");
    }
}
