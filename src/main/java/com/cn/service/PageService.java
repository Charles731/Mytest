package com.cn.service;

import com.cn.entity.User;

import java.util.List;

/**
 * Created by dellpc on 2017/12/1.
 */
public interface PageService {
    List<User> queryUserByPage(int currPage,int pageSize);
}
