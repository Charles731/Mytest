package com.cn.controller;

import com.cn.entity.Admin;
import com.cn.entity.User;
import com.cn.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author vook
 * @date 2017/11/15 16:14
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    //注入Service
    @Autowired
    private AdminService adminService;

//    @RequestMapping("/adLogin")
//    public String adLogin(String a_name, String a_password, Model model) {
//        System.out.println("管理员登录 " + "账号：" + a_name + " 密码：" + a_password);
//        boolean isAdminExist = false;
//        isAdminExist = adminService.adLogin(a_name,a_password);
//        System.out.println("isAdminExist----->" + isAdminExist);
//        if(isAdminExist) {
//            model.addAttribute("a_name",a_name);
//            model.addAttribute("a_password",a_password);
//            return "success";
//        }
//        return "fail";
//
//    }
//    管理员登录
      @RequestMapping(value = "/adLogin",method = RequestMethod.POST)
      @ResponseBody
      public Admin adLogin(@RequestBody Admin requestAdmin) {
           String a_name = requestAdmin.getA_name();
           String a_password = requestAdmin.getA_password();
           Admin admin = adminService.adLogin(a_name,a_password);
           return admin;
     }

//    删除用户
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    @ResponseBody
    public boolean deleteUser(@RequestParam("u_id")int u_id) {
        boolean isSuccess = false;
        isSuccess = adminService.deleteUser(u_id);
        return isSuccess;
    }

   //根据用户名查找用户
    @RequestMapping(value = "/findUserByName", method = RequestMethod.POST)
    @ResponseBody
    public User findUserByName(@RequestParam("u_name")String u_name) {
        User user = adminService.findUserByName(u_name);
        return user;
    }
}
