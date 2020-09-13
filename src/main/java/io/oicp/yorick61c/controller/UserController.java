package io.oicp.yorick61c.controller;


import io.oicp.yorick61c.domain.EbUser;
import io.oicp.yorick61c.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
@RequestMapping("/user")
public class UserController {

    @Resource(name = "UserService")
    private UserService service;

    @RequestMapping("/loginCheck")
    public String loginCheck(EbUser user, HttpSession session){
        EbUser ebUser = service.loginCheck(user);
        if (ebUser != null) {
            session.setAttribute("user",ebUser);
            return "";
        }else {
            session.setAttribute("loginStatus","登录失败，用户名或密码错误。");
            return "/login";
        }
    }



    @RequestMapping("/register")
    public String userRegister(EbUser user) throws IOException {
        service.register(user);
        return "redirect:/reg-result.jsp";
    }


}
