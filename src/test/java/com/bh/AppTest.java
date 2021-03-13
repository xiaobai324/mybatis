package com.bh;

import static org.junit.Assert.assertTrue;

import com.bh.pojo.Person;
import com.bh.pojo.User;
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
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
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
    //根据id查询用户信息
    @Test
    public void testFindUserById() {
        //数据库连接对象
        SqlSession sqlSession = null;
        try {
            //数据库对象实例化
            sqlSession = sqlSessionFactory.openSession();

            //查询单个记录
            User user = sqlSession.selectOne("UserTest.findUserById", 1);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    @Test
    //根据name查询用户信息
    public void testFindUserByName(){
        //数据库对象实例化
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> list = sqlSession.selectList("UserTest.findUserByName","小");
        System.out.println(list.size());
        System.out.println(list);
        //判断是否为空并关闭
        if (sqlSession !=null){
            sqlSession.close();
        }
    }
    //插入数据
    @Test
    public void testInsert(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUsername("金");
        user.setSex("男");
        sqlSession.insert("UserTest.insertUser",user);
       //提交事务
        sqlSession.commit();
    }
    @Test
    public void testInsertUUID(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Person person = new Person();
        person.setUsername("张三");
        sqlSession.insert("UserTest.insertUserUUID",person);
        //提交事务
        sqlSession.commit();
    }
    //根据id删除一条数据
    @Test
    public void testDelete(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.delete("UserTest.deleteUserById",34);
            //提交事务
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    //修改数据
    @Test
    public void testUpdate(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            //修改数据
            User user = new User();
            user.setId(1);
            user.setUsername("杨过");
            sqlSession.update("UserTest.updateUser",user);
            //提交事务
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

}
