package DNA1.controller;//package DNA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/22 15:05
 */
@Controller
@RequestMapping("/user")
public class UserController {
    // 请求地址  http://localhost:8080/user/quick
    @RequestMapping(value = "/quick", method = RequestMethod.GET, params = {"username"})
    public String save() {
        System.out.println("Controller save running....");
        return "success";
    }
}

