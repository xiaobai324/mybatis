package com.bh.dao;

import com.bh.pojo.User;
import com.bh.pojo.UserQueryVo;

import java.util.HashMap;
import java.util.List;

/**
 * @Author:JL
 * @Date:2021/3/10
 */
public interface UserMapper {
    //根据id查寻
    public User findUserById(int id);
    //模糊查询
    public List<User> findUserByUsername(String username) throws  Exception;
    //插入数据
    public void insertUser(User user) throws Exception;
    //用户信息综合查询即多条件查询
    List<UserQueryVo> findUserList(UserQueryVo userQueryVo);
    //传递hashmap测试
    List<User> findUserByHashMap(HashMap<String, Object> map);
    //输出简单类型测试
    int findUserByCount(User user);
    //根据 id 查询用户信息，使用 resultMap 输出
    User findUserByIdResultMap(int i);
    //传递单个 List
    List<User> selectUserByList(List<User> userList);
    //单个数组（数组中是 pojo）
    List<User> selectUserByArray(Object[] userlist);
    //单个数组（数组中是字符串类型）
    List<User> selectUserByArray_(Object[] userlist);
    //修改数据
    void updateUser(User user);
}
