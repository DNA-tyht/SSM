package DNA.service;

import DNA.domain.Role;

import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/25 15:55
 */
public interface RoleService {
    /**
    * @Description 显示所有角色信息
    * @Return []
    * @Author 脱氧核糖
    * @Date 2021/5/25 15:58
    */
    List<Role> list();
}
