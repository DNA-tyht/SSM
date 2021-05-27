package DNA.service.Impl;

import DNA.domain.Account;
import DNA.mapper.AccountMapper;
import DNA.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/27 17:48
 */
@Service(value = "accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void save(Account account) throws IOException {
        accountMapper.save(account);
    }

    @Override
    public List<Account> findAll() throws IOException {
        List<Account> accountList = accountMapper.findAll();
        return accountList;
    }
}
