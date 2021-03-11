package com.bh.dao.impl;

import java.util.List;

/**
 * @Author:JL
 * @Date:2021/3/11
 */
public interface OrdersCustomMapper {
    List<OrdersCustomMapper> findOrdersList();

    List<OrdersCustomMapper> findOrdersListResultMap();
}
