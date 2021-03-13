package com.bh.pojo;

/**
 * @Author:JL
 * @Date:2021/3/11
 */
public class Orderdetail {
    private int id;         //
    private int orders_id;   //订单id
    private int items_id;    //商品id
    private int items_num;    //商品购买数量
    private Items items;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(int orders_id) {
        this.orders_id = orders_id;
    }

    public int getItems_id() {
        return items_id;
    }

    public void setItems_id(int items_id) {
        this.items_id = items_id;
    }

    public int getItems_num() {
        return items_num;
    }

    public void setItems_num(int items_num) {
        this.items_num = items_num;
    }

    @Override
    public String toString() {
        return "Orderdetail{" +
                "id=" + id +
                ", orders_id=" + orders_id +
                ", items_id=" + items_id +
                ", items_num=" + items_num +
                ", items=" + items +
                '}';
    }
}
