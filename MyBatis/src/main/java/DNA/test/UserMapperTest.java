package DNA.test;

import DNA.mapper.UserMapper;
import DNA.domain.User;
import DNA.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/26 21:24
 */
public class UserMapperTest {
    @Test
    public void findByCondition() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.init();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User(1, null, null, null);
        List<User> userList = mapper.findByCondition(user);
        System.out.println(userList);
        SqlSessionUtils.destroy(sqlSession);
    }

    @Test
    public void findByIds() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.init();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        List<User> userList = mapper.findByIds(ids);
        System.out.println(userList);
        SqlSessionUtils.destroy(sqlSession);
    }
}
