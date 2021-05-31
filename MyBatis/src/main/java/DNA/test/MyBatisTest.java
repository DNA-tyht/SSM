package DNA.test;

import DNA.mapper.UserMapper;
import DNA.domain.User;
import DNA.utils.SqlSessionUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/26 11:21
 */
public class MyBatisTest {
    @Test
    public void findAll() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.init();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //设置分页的相关参数
        PageHelper.startPage(1, 2);
        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        //获取分页相关参数
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        System.out.println("总条数："+pageInfo.getTotal());
        System.out.println("总页数："+pageInfo.getPages());
        System.out.println("当前页："+pageInfo.getPageNum());
        System.out.println("每页显示长度："+pageInfo.getPageSize());
        System.out.println("是否第一页："+pageInfo.isIsFirstPage());
        System.out.println("是否最后一页："+pageInfo.isIsLastPage());
        SqlSessionUtils.destroy(sqlSession);
    }

    @Test
    public void save() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.init();
        User user = new User(3, "tom", "123", new Date(100241400));
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.save(user);
        SqlSessionUtils.destroy(sqlSession);
    }

    @Test
    public void update() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.init();
        User user = new User(3, "marry", "123", new Date(100241400));
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.update(user);
        SqlSessionUtils.destroy(sqlSession);
    }

    @Test
    public void delete() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.init();
        sqlSession.delete("userMapper.delete", 3);
        SqlSessionUtils.destroy(sqlSession);
    }
}
