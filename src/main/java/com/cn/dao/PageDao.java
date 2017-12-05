package com.cn.dao;

import com.cn.entity.User;
import java.util.List;

/**
 * Created by dellpc on 2017/11/30.
 */
public interface PageDao {
    List<User> queryUserByPage();
}
