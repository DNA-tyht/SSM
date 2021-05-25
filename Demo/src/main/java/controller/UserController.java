package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @RequestMapping(value="/quick")
    public String save1(){
        System.out.println("Controller save running....");
        return "index.jsp";
    }
}
