package com.cn.entity;

import org.springframework.stereotype.Component;

/**
 * Created by User on 2017/10/26.
 */
@Component
public class Store {

    /*
    * 商品的id，名字，价格
    * */
    private int item_id;
    private String name;
    private double price;

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
