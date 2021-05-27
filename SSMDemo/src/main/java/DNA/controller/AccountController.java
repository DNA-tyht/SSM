package DNA.controller;

import DNA.domain.Account;
import DNA.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/27 17:49
 */
@Controller
@RequestMapping(value = "/account", produces = "text/html;charset=UTF-8")
public class AccountController {
    @Autowired
    private AccountService accountService;

    //保存
    @RequestMapping(value = "/save")
    @ResponseBody //不进行页面跳转
    public String save(Account account) throws IOException {
        accountService.save(account);
        return "save success";
    }

    //查询
    @RequestMapping(value = "/findAll")
    public ModelAndView findAll(ModelAndView modelAndView) throws IOException {
        List<Account> accountList = accountService.findAll();
        modelAndView.addObject("accountList", accountList);
        modelAndView.setViewName("accountList");
        return modelAndView;
    }
}
