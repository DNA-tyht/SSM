package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value="/quick",method = RequestMethod.GET)
    public String save1(){
        System.out.println("Controller save running....");
        return "index.jsp";
    }
}
