package top.testcross.zuji.controller.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import top.testcross.zuji.service.IUimUserService;

@Controller
public class UserController {
    @Autowired
    IUimUserService userService;
}
