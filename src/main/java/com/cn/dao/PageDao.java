package com.cn.dao;

import com.cn.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by dellpc on 2017/11/30.
 */
public interface PageDao {
    List<User> queryUserByPage();
}
