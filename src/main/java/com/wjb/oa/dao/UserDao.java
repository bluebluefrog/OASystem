package com.wjb.oa.dao;

import com.wjb.oa.entity.User;
import com.wjb.oa.utils.MyBatisUtils;

public class UserDao {
    public User selectByUserName(String username){
        return (User) MyBatisUtils.executeQuery(sqlSession -> sqlSession.selectOne("usermapper.selectByUsername", username));
    }
}
