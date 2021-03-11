package com.bh.dao.impl;

import com.bh.pojo.User;
import com.bh.pojo.UserQueryVo;

import java.util.HashMap;
import java.util.List;

/**
 * @Author:JL
 * @Date:2021/3/10
 */
public interface UserMapper {
    //
    public User findUserById(int id) throws Exception;
    //
    public List<User> findUserByUsername(String username) throws  Exception;
    //
    public void insertUser(User user) throws Exception;

    List<UserQueryVo> findUserList(UserQueryVo userQueryVo);

    List<User> findUserByHashMap(HashMap<String, Object> map);

    int findUserByCount(User user);

    User findUserByIdResultMap(int i);

    List<User> selectUserByList(List<User> userList);

    List<User> selectUserByArray(Object[] userlist);

    List<User> selectUserByArrayString(Object[] userlist);
}
