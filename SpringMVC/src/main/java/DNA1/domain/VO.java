package DNA1.domain;

import java.util.List;
/**
* @Description 封装了user集合
* @Return
* @Author 脱氧核糖
* @Date 2021/5/24 11:30
*/
public class VO {

    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "VO{" +
                "userList=" + userList +
                '}';
    }
}
