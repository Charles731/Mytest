package com.cn.service;

import com.cn.entity.User;

/**
 * Created by User on 2017/10/31.
 */
public interface UserService {

    //用户注册
    boolean regist(User user);
    //用户登录
    User login(String u_name, String password);
}
