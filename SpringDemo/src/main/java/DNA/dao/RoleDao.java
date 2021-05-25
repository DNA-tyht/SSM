package DNA.dao;

import DNA.domain.Role;

import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/25 15:59
 */
public interface RoleDao {
    /**
    * @Description 查询所有角色信息
    * @Return []
    * @Author 脱氧核糖
    * @Date 2021/5/25 16:02
    */
    public List<Role> queryAll();
}
