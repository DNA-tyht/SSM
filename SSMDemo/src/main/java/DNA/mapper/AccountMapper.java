package DNA.mapper;

import DNA.domain.Account;

import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/27 17:38
 */
public interface AccountMapper {

    public void save(Account account);

    public List<Account> findAll();
}
