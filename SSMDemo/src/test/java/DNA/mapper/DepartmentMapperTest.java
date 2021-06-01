package DNA.mapper;

import DNA.bean.Department;
import DNA.bean.DepartmentExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/31 22:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationConfig.xml"})
public class DepartmentMapperTest {
    @Autowired
    DepartmentMapper departmentMapper;
    Department department = new Department(3, "运维部");
    DepartmentExample departmentExample = new DepartmentExample();

    @Test
    public void countByExample() {
        System.out.println(departmentMapper.countByExample(departmentExample));
    }

    @Test
    public void deleteByPrimaryKey() {
        System.out.println(departmentMapper.deleteByPrimaryKey(3));
    }

    @Test
    public void insert() {
        System.out.println(departmentMapper.insert(department));
    }

    @Test
    public void insertSelective() {
        System.out.println(departmentMapper.insertSelective(department));
    }

    @Test
    public void selectByExample() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByExampleSelective() {
    }

    @Test
    public void updateByExample() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}