package DNA.dao;

import DNA.domain.User;

import java.io.IOException;
import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/26 17:23
 */
public interface UserMapper {
    public List<User> findAll() throws IOException;

    public void update(User user) throws IOException;

    public List<User> findByCondition(User user);

    public List<User> findByIds(List<Integer> ids);

    public void save(User user);
}
