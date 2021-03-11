package com.bh;

import com.bh.dao.impl.OrdersCustomMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * @Author:JL
 * @Date:2021/3/11
 */
public class OrdersCustomMapperTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void createSqlSessionFactory() throws IOException {
        //获取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    //查询所有订单
    @Test
    public void testFindOrdersList(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
        //调用方法
        List<OrdersCustomMapper> ordersCustomMappers = ordersCustomMapper.findOrdersList();
        System.out.println(ordersCustomMappers);
        //关闭sqlSession
        sqlSession.close();
    }
    @Test
    public void testFindOrdersListResultMap(){
        //创建sqlSession连接
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理对象
        OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
        //调用方法完成功能
        List<OrdersCustomMapper> ordersCustomMappers =ordersCustomMapper.findOrdersListResultMap();
        System.out.println(ordersCustomMappers);
        //关闭连接，释放资源
        sqlSession.close();
    }
}
