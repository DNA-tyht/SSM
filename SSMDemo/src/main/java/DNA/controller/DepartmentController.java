package DNA.controller;

import DNA.bean.Department;
import DNA.bean.Msg;
import DNA.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/6/3 15:58
 */
@Controller
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    /**
    * @Description 返回所有部门信息
    * @Return []
    * @Author 脱氧核糖
    * @Date 2021/6/3 16:01
    */
    @ResponseBody
    @RequestMapping(value = "/depts")
    private Msg getDepts() {
        List<Department> depts = departmentService.getDepts();
        return Msg.success().add("depts", depts);
    }
}
