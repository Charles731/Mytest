package com.cn.entity;

import org.springframework.stereotype.Component;

/**
 * Created by User on 2017/10/26.
 */
@Component
public class Forum {

    /*
    * 发帖的id，标题，内容
    * */
    private int r_id;
    private String title;
    private String content;

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
