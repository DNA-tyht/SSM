package DNA.controller;

import DNA.domain.Role;
import DNA.domain.User;
import DNA.service.RoleService;
import DNA.service.UserService;
import com.mysql.cj.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/25 20:19
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/list")
    public ModelAndView list(ModelAndView modelAndView) {
        List<User> userList = userService.queryAllUser();
        modelAndView.addObject("userList", userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping(value = "/saveUI")
    public ModelAndView saveUI(ModelAndView modelAndView) {
        List<Role> roleList = roleService.queryAllRole();
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("user-add");
        return modelAndView;
    }

    @RequestMapping(value = "/save")
    public String save(User user, Long[] roleIds) {
        userService.addUser(user, roleIds);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/delete/{userId}")
    public String delete(@PathVariable(value = "userId") Long userId) {
        userService.deleteUserById(userId);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/login")
    public String login(String username, String password, HttpSession session) {
        User user = userService.login(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/index.jsp";
        }
        return "redirect:/login.jsp";
    }
}
