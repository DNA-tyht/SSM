package DNA.dao.Impl;

import DNA.dao.UserDao;
import DNA.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/25 20:23
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> queryAllUser() {
        return jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public Long addUser(User user) {
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into sys_user values(?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1, null);
                preparedStatement.setString(2, user.getUsername());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setString(5, user.getPhoneNum());
                return preparedStatement;
            }
        };
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(creator, keyHolder);
        long userId = keyHolder.getKey().longValue();
        return userId;
    }

    @Override
    public void addUserRole(Long userId, Long[] roleIds) {
        for (Long roleId : roleIds) {
            jdbcTemplate.update("insert into sys_user_role values(?, ?)", userId, roleId);
        }
    }

    @Override
    public void deleteUserRole(Long userId) {
        jdbcTemplate.update("delete from sys_user_role where userId = ?", userId);
    }

    @Override
    public void deleteUser(Long userId) {
        jdbcTemplate.update("delete from sys_user where id = ?", userId);
    }

    @Override
    public User queryUsernameAndPassword(String username, String password) {
        return jdbcTemplate.queryForObject("select * from sys_user where username = ? and password = ?", new BeanPropertyRowMapper<User>(User.class), username, password);
    }
}
