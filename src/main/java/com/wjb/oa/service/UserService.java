package com.wjb.oa.service;

import com.wjb.oa.dao.RbacDao;
import com.wjb.oa.dao.UserDao;
import com.wjb.oa.entity.Node;
import com.wjb.oa.entity.User;
import com.wjb.oa.exception.BusinessException;
import com.wjb.oa.utils.MD5Utils;

import java.util.List;

public class UserService {

    private UserDao userDao = new UserDao();

    private RbacDao rbacDao = new RbacDao();

    public User checkLogin(String username, String password) {
        User user = userDao.selectByUserName(username);
        if (user == null) {
            //抛出用户不存在异常
            throw new BusinessException("L001", "用户名不存在");
        }
        String md5 = MD5Utils.md5Digest(password, user.getSalt());
        if (!md5.equals(user.getPassword())) {
            throw new BusinessException("L002", "密码错误");
        }
        return user;
    }

    public List<Node> selectNodeByUserId(Long userId){
        List<Node> nodeList = rbacDao.selectNodeByUserId(userId);
        return nodeList;
    }
}
