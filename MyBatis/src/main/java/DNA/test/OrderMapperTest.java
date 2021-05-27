package DNA.test;

import DNA.dao.OrderMapper;
import DNA.domain.Order;
import DNA.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/27 15:26
 */
public class OrderMapperTest {
    @Test
    public void findAll() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.init();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orderList = mapper.findAll();
        for (Order order : orderList) {
            System.out.println(order);
        }
        SqlSessionUtils.destroy(sqlSession);
    }
}
