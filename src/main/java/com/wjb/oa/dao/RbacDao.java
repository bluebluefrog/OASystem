package com.wjb.oa.dao;

import com.wjb.oa.entity.Node;
import com.wjb.oa.utils.MyBatisUtils;

import java.util.List;

public class RbacDao {
    public List<Node> selectNodeByUserId(Long userId){
        return (List)MyBatisUtils.executeQuery(sqlSession -> sqlSession.selectList("rbacmapper.selectNodeByUserId", userId));
    }
}
