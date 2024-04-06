package com.OOZone.controller;
import com.OOZone.service.UserService;
import com.OOZone.entity.User;
import com.OOZone.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public String login(@ModelAttribute("user")User user, HttpServletRequest request){
        try {
            String MD5pwd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
            user.setPassword(MD5pwd);
        } catch (Exception e) {
            user.setPassword("");
        }
        User resultUser = userService.login(user);
        if (resultUser == null) {
            request.setAttribute("user", user);
            request.setAttribute("errorMsg", "请认真核对账号、密码！");
            return "login";
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", resultUser);
            return "redirect:/views/main.jsp";
        }
    }
    @RequestMapping(value = "/register.do", method = RequestMethod.POST)

    public String register(@ModelAttribute("user")User user, HttpServletRequest request){

        User resultUser = userService.register(user);
        if(resultUser.getRoleName()!=null){
            request.setAttribute("user", user);
            request.setAttribute("errorMsg", "用户名已被注册");
            return "redirect:/views/register.jsp";
        } else if (resultUser.getUserName()!=null) {
            request.setAttribute("user", user);
            request.setAttribute("errorMsg", "账号已被注册");
            return "redirect:/views/register.jsp";
        }
        else {
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", resultUser);
            return "redirect:/views/main.jsp";
        }
    }
}
