package io.oicp.yorick61c.controller;


import com.alibaba.druid.support.json.JSONParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.oicp.yorick61c.domain.EbUser;
import io.oicp.yorick61c.domain.PageBean;
import io.oicp.yorick61c.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController {

    @Resource(name = "UserService")
    private UserService service;

    @RequestMapping("/quit")
    public String quit(HttpSession session){
        session.removeAttribute("user");
        session.removeAttribute("recentView");
        //清空浏览记录
        return "redirect:/index/welcome/1/8";
    }

    @RequestMapping(value = "/checkUsername",produces="text/html;charset=UTF-8;")
    @ResponseBody
    public String ajaxCheck(String username){
        EbUser userById = service.findUserById(username);
        if (userById == null) {
            return "该用户名可以使用";
        } else {
            return "该用户名已被注册，不可使用";
        }
    }

    @RequestMapping("/loginCheck")
    public String loginCheck(EbUser user, HttpSession session){
        EbUser ebUser = service.loginCheck(user);
        if (ebUser != null) {
            session.setAttribute("user",ebUser);
            return "redirect:/index/welcome/1/8";
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
        return "redirect:/user/userList/1/10";
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
