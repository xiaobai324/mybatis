package com.bh.dao;

import com.bh.pojo.Orderdetail;
import com.bh.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:JL
 * @Date:2021/3/11
 */
public interface OrdersCustomMapper {
    //查询所有订单
    List<OrdersCustomMapper> findOrdersList();
    //查询所有订单
    List<OrdersCustomMapper> findOrdersListResultMap();
    //一对多查询:查询订单及订单下的详情信息
    List<Orderdetail> findOrdersDetailList();
    //多对多，查询用户信息，关联查询订单，订单明细，商品信息
    List findUserOrderListResultMap();


}
