package DNA.controller;

import DNA.bean.Employee;
import DNA.bean.Msg;
import DNA.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
    * @Description 返回所有员工信息
    * @Return [pn, modelAndView]
    * @Author 脱氧核糖
    * @Date 2021/6/3 16:02
    */
    @ResponseBody
    @RequestMapping(value = "/emps")
    public Msg getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 5);
        List<Employee> emps = employeeService.getAll();
        return Msg.success().add("pageInfo", new PageInfo(emps, 5));
    }
    /**
    * @Description 新增一条员工信息
    * @Return [employee]
    * @Author 脱氧核糖
    * @Date 2021/6/3 16:28
    */
    @ResponseBody
    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public Msg saveEmp(@Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, Object> map = new HashMap<>();
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error : errors) {
                map.put(error.getField(), error.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);
        } else {
            employeeService.saveEmp(employee);
            return Msg.success();
        }
    }

    /**
    * @Description 检查用户名是否可用
    * @Return [empName]
    * @Author 脱氧核糖
    * @Date 2021/6/3 19:41
    */
    @ResponseBody
    @RequestMapping(value = "/checkUser")
    public Msg checkUser(@RequestParam(value = "empName") String empName) {
        //先判断用户名是否是合法的表达式;
        String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
        if (!empName.matches(regx)) {
            return Msg.fail().add("va_msg", "用户名是6-16位数字和字母的组合或2-5位中文！");
        }
        //数据库用户名重复校验
        boolean is = employeeService.checkUser(empName);
        if (is ){
            return Msg.success();
        } else {
            return Msg.fail().add("va_msg", "用户名不可用！");
        }
    }
    /**
    * @Description 查询一条员工信息
    * @Return []
    * @Author 脱氧核糖
    * @Date 2021/6/4 8:55
    */
    @RequestMapping(value="/emp/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Msg getEmp(@PathVariable("id") Integer id){
        Employee employee = employeeService.getEmp(id);
        return Msg.success().add("emp", employee);
    }
    /**
    * @Description 更新一条员工信息
    * @Return [employee, result]
    * @Author 脱氧核糖
    * @Date 2021/6/4 10:39
    */
    @ResponseBody
    @RequestMapping(value = "/emp/{empId}", method = RequestMethod.PUT)
    public Msg saveEmp(Employee employee) {
        employeeService.updateEmp(employee);
        return Msg.success();
    }

    /**
    * @Description 根据ID删除员工
    * @Return []
    * @Author 脱氧核糖
    * @Date 2021/6/4 15:59
    */
    @ResponseBody
    @RequestMapping(value = "/emp/{ids}", method = RequestMethod.DELETE)
    public Msg deleteEmpById(@PathVariable("ids") String ids) {
        if (ids.contains("-")) {
            List<Integer> delete = new ArrayList<>();
            String[] strings = ids.split("-");
            for (String id : strings) {
                delete.add(Integer.parseInt(id));
            }
            employeeService.deleteBatch(delete);
        } else {
            employeeService.deleteEmp(Integer.parseInt(ids));
        }
        return Msg.success();
    }
}
