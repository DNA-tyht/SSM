package DNA.dao.Impl;

import DNA.dao.RoleDao;
import DNA.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/25 16:00
 */
public class RoleDaoImpl implements RoleDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Role> queryAllRole() {
        return jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));
    }

    @Override
    public void addRole(Role role) {
        jdbcTemplate.update("insert into sys_role values(?, ?, ?)", null, role.getRoleName(), role.getRoleDesc());
    }

    @Override
    public List<Role> queryRoleByUserId(Long id) {
        return jdbcTemplate.query("select * from sys_user_role ur, sys_role r where ur.roleId = r.id and ur.userId = ?", new BeanPropertyRowMapper<Role>(Role.class), id);
    }
}
