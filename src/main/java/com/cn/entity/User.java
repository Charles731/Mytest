package com.cn.entity;

import org.springframework.stereotype.Component;

/**
 * Created by User on 2017/10/26.
 */
@Component
public class User {

    /*
    * 文件id，密码，电子邮件，电话号码
    * */
    private int u_id;
    private String u_name;
    private String password;
    private String email;
    private String phone;

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
