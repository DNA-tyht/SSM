package DNA.service;

import DNA.bean.Employee;
import DNA.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/6/1 15:28
 */
@Service("employeeService")
public class EmployeeService {
    @Resource
    EmployeeMapper employeeMapper;

    public List<Employee> getAll() {
        return employeeMapper.selectByExampleWithDept(null);
    }
}
