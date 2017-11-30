package com.cn.service;

import com.cn.dao.UserDao;
import com.cn.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 业务层
 * Created by User on 2017/10/31.
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public boolean regist(User user) {
        boolean isSuccess = false;
        int number = 0;
        number = userDao.addUser(user);
        if(number > 0) {
            isSuccess = true;
            return isSuccess;
        }
        return isSuccess;
    }

    public User login(String u_name, String password) {

        User user = userDao.findUserByNameAndPwd(u_name, password);
        if(user != null) {
            return user;
        }
        return null;

    }

}
