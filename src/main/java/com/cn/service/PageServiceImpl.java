package com.cn.service;

import com.cn.dao.PageDao;
import com.cn.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by dellpc on 2017/12/1.
 */
public class PageServiceImpl implements PageService{
    private PageDao pageDao;

    public List<User> queryUserByPage(int currPage, int pageSize) {
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("currPage",currPage);
        data.put("pageSize",pageSize);
        return pageDao.queryUserByPage(data);
    }
}
