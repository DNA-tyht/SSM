package DNA.controller;

import DNA.domain.Role;
import DNA.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/25 15:53
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/list")
    public ModelAndView list(ModelAndView modelAndView) {
        List<Role> roleList = roleService.queryAllRole();
        //设置模型
        modelAndView.addObject("roleList", roleList);
        //设置视图
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping(value = "/save")
    public String save(Role role) {
        roleService.addRole(role);
        return "redirect:/role/list";
    }
}
