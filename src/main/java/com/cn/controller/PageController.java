package com.cn.controller;

import com.cn.entity.Page;
import com.cn.entity.User;
import com.cn.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dellpc on 2017/12/1.
 */
@Controller
@RequestMapping("/page")
public class PageController {

    @Autowired
    PageService pageService;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public List<User> getUserByPage(@RequestBody Page page) {

        int currPage = page.getCurrPage();
        int pageSize = page.getPageSize();
        System.out.println("currPage:" + currPage + " pageSize:" + pageSize);
        List<User> users = pageService.queryUserByPage(currPage,pageSize);
        return users;
    }
}
