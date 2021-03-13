package com.bh.pojo;

/**
 * @Author:JL
 * @Date:2021/3/12
 */
public class Items {
    private int id;          //商品id
    private String name;     //商品名称
    private String detail;   //商品描述

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
