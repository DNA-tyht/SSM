package DNA.mapper;

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
    public List<Role> queryAllRole();

    /**
    * @Description 添加一条角色信息
    * @Return [role]
    * @Author 脱氧核糖
    * @Date 2021/5/25 20:07
    */
    void addRole(Role role);

    /**
    * @Description 根据用户id查询角色信息
    * @Return [id]
    * @Author 脱氧核糖
    * @Date 2021/5/25 20:46
    */
    List<Role> queryRoleByUserId(Long id);
}
