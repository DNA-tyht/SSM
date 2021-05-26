package DNA.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/26 21:32
 */
public class SqlSessionUtils {
    public static SqlSession init() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取session会话对象
        return sqlSessionFactory.openSession();
    }

    public static void destroy(SqlSession sqlSession) {
        //MyBatis默认事务不提交
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }
}
