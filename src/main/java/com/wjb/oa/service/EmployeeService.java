package com.wjb.oa.service;

import com.wjb.oa.dao.EmployeeDao;
import com.wjb.oa.entity.Employee;
import com.wjb.oa.utils.MyBatisUtils;

public class EmployeeService {
    public Employee selectById(Long employeeId) {
        return (Employee) MyBatisUtils.executeQuery(sqlSession -> {
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            return employeeDao.selectById(employeeId);
        });
    }
}
