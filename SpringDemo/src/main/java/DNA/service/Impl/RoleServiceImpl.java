package DNA.service.Impl;

import DNA.mapper.RoleDao;
import DNA.domain.Role;
import DNA.service.RoleService;

import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/25 15:55
 */
public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> queryAllRole() {
        return roleDao.queryAllRole();
    }

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }
}
