package DNA.domain;

import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/25 13:42
 */
public class User {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;
    //当前用户具备的角色
    private List<Role> roles;

    public User() {
    }

    public User(Long id, String username, String email, String password, String phoneNum, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNum = phoneNum;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", roles=" + roles +
                '}';
    }
}
