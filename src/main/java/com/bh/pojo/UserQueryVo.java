package com.bh.pojo;

import java.util.List;

/**
 * @Author:JL
 * @Date:2021/3/10
 */
public class UserQueryVo {
    //传入多个id
    private List<Integer> ids;
    private User user;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
