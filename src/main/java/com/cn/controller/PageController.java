package com.cn.controller;

import com.cn.entity.User;
import com.cn.service.PageService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by dellpc on 2017/12/1.
 */
@ResponseBody
@RequestMapping("")
public class PageController {

    public List<User> getUserByPage(@PathVariable("currPage") int currPage, @PathVariable("pageSize") int pageSize) {
        PageService pageService;
        List<User> user = pageService.queryUserByPage(currPage,pageSize);
    }
}
