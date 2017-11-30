package com.cn.entity;

import org.springframework.stereotype.Component;

/**
 * Created by User on 2017/10/26.
 */
@Component
public class File {

    /*
    * 文件id，名字，相关描述
    * */
    private int f_id;
    private String name;
    private String description;

    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
