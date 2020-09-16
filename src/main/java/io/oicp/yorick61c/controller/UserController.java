package io.oicp.yorick61c.controller;


import io.oicp.yorick61c.domain.EbUser;
import io.oicp.yorick61c.domain.PageBean;
import io.oicp.yorick61c.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


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

    @RequestMapping("/userList/{currentPage}/{rows}")
    public ModelAndView findUserList(@PathVariable Integer currentPage, @PathVariable Integer rows) throws IOException {
        if (currentPage == null){
            currentPage = 1;
        }
        if(rows == null){
            rows = 10;
        }
        PageBean<EbUser> userByPage = service.findUserByPage(currentPage, rows);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("manage/user");
        modelAndView.addObject("ebUser",userByPage);
        return modelAndView;
    }

    @RequestMapping("/delUser/{userId}")
    public String delUser(@PathVariable String userId){
        service.deleteUserById(userId);
        return "redirect:/user/userList/1/10";
    }


    @RequestMapping("/register")
    public String userRegister(EbUser user) throws IOException {
        service.register(user);
        return "redirect:/reg-result.jsp";
    }

    @RequestMapping("/beforeUpdate/{userId}")
    public ModelAndView beforeUpdateUser(@PathVariable String userId){
        EbUser user = service.findUserById(userId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ebUser",user);
        modelAndView.setViewName("manage/user-modify");
        return modelAndView;
    }

    @RequestMapping("/update")
    public String updateUser(EbUser user){
        service.updateUser(user);
        return "redirect:/user/userList/1/10";
    }


}
