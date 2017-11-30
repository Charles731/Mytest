package com.cn.controller;

import com.cn.entity.User;
import com.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by User on 2017/10/27.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    //注入Service
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    @ResponseBody
    public boolean regist(@RequestBody User user) {

        boolean isSuccess = false;
        isSuccess = userService.regist(user);
        return isSuccess;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public User login(@RequestBody User requestUser) {
        String u_name = requestUser.getU_name();
        String password = requestUser.getPassword();
        System.out.println("u_name" + u_name);
        User user = userService.login(u_name,password);
        return user;
    }
}
