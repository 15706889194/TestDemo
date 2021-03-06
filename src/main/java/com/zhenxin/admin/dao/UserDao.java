package com.zhenxin.admin.dao;

import com.zhenxin.pojo.User;
import com.zhenxin.pojo.UserExample;

public class UserDao {
    public static UserExample findUser(String userName){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        return userExample;
    }


    public static UserExample findUserById(int userId){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return userExample;
    }


    public static UserExample updateToken(Integer userId){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return userExample;
    }

}
