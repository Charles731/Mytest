package com.cn.entity;

import org.springframework.stereotype.Component;

/**
 * Created by User on 2017/10/26.
 */
@Component
public class Help {

    /*
    * 帮助id，咨询的问题和答案
    * */
    private int h_id;
    private String question;
    private String answer;

    public int getH_id() {
        return h_id;
    }

    public void setH_id(int h_id) {
        this.h_id = h_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
