package com.OOZone.controller;
import com.OOZone.service.UserService;
import com.OOZone.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    /**
     * 登录
     *
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request){
        /*TODO*/
        return new String();
    }
}
