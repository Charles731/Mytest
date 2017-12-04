package com.cn.entity;

import org.springframework.stereotype.Component;

/**
 * Created by dellpc on 2017/12/1.
 */
@Component
public class Page {
    int currPage;
    int pageSize;

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
