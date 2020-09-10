package io.oicp.yorick61c.controller;


import io.oicp.yorick61c.domain.EbUser;
import io.oicp.yorick61c.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


@Controller
@RequestMapping("/user")
public class UserController {

    @Resource(name = "UserService")
    private UserService service;



    @RequestMapping("/register")
    public String userRegister(EbUser user){
        service.register(user);

        return null;
    }


}
