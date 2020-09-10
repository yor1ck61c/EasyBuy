package io.oicp.yorick61c.controller;


import io.oicp.yorick61c.domain.EbUser;
import io.oicp.yorick61c.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;


@Controller
@RequestMapping("/user")
public class UserController {

    @Resource(name = "UserService")
    private UserService service;



    @RequestMapping("/register")
    public String userRegister(EbUser user) throws IOException {
        service.register(user);
        return "redirect:/reg-result.jsp";
    }


}
