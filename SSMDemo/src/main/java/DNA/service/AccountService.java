package DNA.service;

import DNA.domain.Account;

import java.io.IOException;
import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/27 17:49
 */
public interface AccountService {
    public void save(Account account) throws IOException;

    public List<Account> findAll() throws IOException;
}