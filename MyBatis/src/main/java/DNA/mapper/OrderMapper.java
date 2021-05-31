package DNA.mapper;

import DNA.domain.Order;

import java.io.IOException;
import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/27 15:11
 */
public interface OrderMapper {
    public List<Order> findAll() throws IOException;
}
