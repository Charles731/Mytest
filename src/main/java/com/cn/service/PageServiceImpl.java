package com.cn.service;

import com.cn.dao.PageDao;
import com.cn.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by dellpc on 2017/12/1.
 */

@Service("pageService")
public class PageServiceImpl implements PageService{

    @Autowired
    private PageDao pageDao;

    public List<User> queryUserByPage(int currPage, int pageSize) {
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("currPage",currPage);
        data.put("pageSize",pageSize);
        List<User> users = pageDao.queryUserByPage(data);
        return users;
    }
}
