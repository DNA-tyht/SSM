package DNA.controller;

import DNA.bean.Employee;
import DNA.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/6/1 15:25
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/emps")
    public ModelAndView getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn, ModelAndView modelAndView) {
        PageHelper.startPage(pn, 5);
        List<Employee> emps = employeeService.getAll();
        modelAndView.addObject("pageInfo", new PageInfo(emps, 5));
        modelAndView.setViewName("list");
        return modelAndView;
    }
}
