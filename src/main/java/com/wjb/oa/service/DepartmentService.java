package com.wjb.oa.service;

import com.wjb.oa.dao.DepartmentDao;
import com.wjb.oa.entity.Department;
import com.wjb.oa.utils.MyBatisUtils;

public class DepartmentService {

    public Department selectById(Long departmentId){
        return (Department)MyBatisUtils.executeQuery(sqlSession -> {
            DepartmentDao mapper = sqlSession.getMapper(DepartmentDao.class);
            return mapper.selectById(departmentId);
        });
    }
}
