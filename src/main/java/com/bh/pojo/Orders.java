package com.bh.pojo;

import java.util.List;

/**
 * @Author:JL
 * @Date:2021/3/11
 */
public class Orders {
    private int id;
    private int user_id;  //用户id
    private String number; //订单号
    private String username; //用户名
    private String address; //地址
    private User user;
    private List<Orderdetail> orderdetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Orderdetail> getOrderdetails() {
        return orderdetails;
    }

    public void setOrderdetails(List<Orderdetail> orderdetails) {
        this.orderdetails = orderdetails;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", number='" + number + '\'' +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", user=" + user +
                ", orderdetails=" + orderdetails +
                '}';
    }
}
