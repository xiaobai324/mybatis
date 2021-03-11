package com.bh;

import com.bh.dao.impl.UserMapper;
import com.bh.pojo.User;
import com.bh.pojo.UserQueryVo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author:JL
 * @Date:2021/3/10
 */
public class UserMapperTest {
    //会话工厂
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void createSqlSessionFactory() throws IOException {
        //获取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    //根据id查寻
    @Test
    public void testFindUserById() throws Exception {
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(1);
        System.out.println(user);
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
    //模糊查询
    @Test
    public void testFindUserByUsername() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.findUserByUsername("小");
        System.out.println(list.size());
        System.out.println(list);
        //判断并关闭sqlSession
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
    //插入数据
    @Test
    public void testInsertUser() throws Exception {
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //添加数据
        User user = new User();
        user.setUsername("小龙女");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("济南");
        //通过mapper接口添加用户
        userMapper.insertUser(user);
        //提交事务
        sqlSession.commit();
        //判断并关闭sqlSession
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
    //传递 pojo 包装对象
    @Test
    public void testFindUserList(){
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //创建包装对象
        UserQueryVo userQueryVo = new UserQueryVo();
        User user = new User();
        user.setUsername("小龙女");
        user.setSex("女");
        //传入多个id
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(99);
        ids.add(88);
        //将ids通过userQueryVo传入statement中
        userQueryVo.setIds(ids);
        userQueryVo.setUser(user);
        //调用方法完成多条件查询
        List<UserQueryVo> userQueryVoList = userMapper.findUserList(userQueryVo);
        System.out.println(userQueryVoList.size());
        System.out.println(userQueryVoList);
        //释放资源
        sqlSession.close();
    }
    //传递hashmap
    @Test
    public void testFindUserByHashMap(){
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //构造查询条件，即Map
        HashMap<String,Object> map = new HashMap<>();
        map.put("id",1);
        map.put("username","王");
        //传递对象完成查询
        List<User> list = userMapper.findUserByHashMap(map);
        System.out.println(list.size());
        System.out.println(list);
        //关闭连接
        sqlSession.close();
    }
    //输出简单类型
    @Test
    public void testFindUserCount(){
        //获取 session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取接口对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("王五");
        //传递对象完成查询
        int count = userMapper.findUserByCount(user);
        System.out.println(count);
        //释放 session
        sqlSession.close();
    }
    //根据 id 查询用户信息，使用 resultMap 输出
    @Test
    public void testFindUserByIdResultMap() {
        //获取对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取 UserMapper 对象，mybatis 自动生成代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用方法完成功能
        User user = userMapper.findUserByIdResultMap(1);
        System.out.println(user);
        //释放资源
        sqlSession.close();
    }
}
