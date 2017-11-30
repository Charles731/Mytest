package com.cn.dao;

import com.cn.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


/**
 * 持久层映射接口
 * Created by User on 2017/10/31.
 */
public interface UserDao {

    //添加用户
    public int addUser(User user);

    //根据用户名和密码查询用户
    //注解的两个参数会自动封装成map集合，括号内即为键
    public User findUserByNameAndPwd(@Param("u_name") String u_name, @Param("password") String password);

}
