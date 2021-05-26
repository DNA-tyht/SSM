package DNA.test;

import DNA.dao.UserDao;
import DNA.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/18 15:58
 */
public class SpringTest {

    public static void main(String[] args) throws Exception {
        SpringTest springTest = new SpringTest();
        springTest.test1();
        springTest.test1();
    }
    /**
    * @Description bean的测试
    * @Return []
    * @Author 脱氧核糖
    * @Date 2021/5/18 16:32
    */
        public void test1() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        UserDao userDao2 = (UserDao) app.getBean("userDao");
        System.out.println(userDao1);
        System.out.println(userDao2);
        app.close();
    }

    /**
    * @Description service的测试
    * @Return []
    * @Author 脱氧核糖
    * @Date 2021/5/18 16:33
    */
    public void test2() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext-DNA1.xml");
        UserService userService = (UserService) app.getBean("userService");
        userService.save();
        //UserService userService = new UserServiceImpl();
        //userService.save();
    }
}
