package com.wjb.oa.dao;

import com.wjb.oa.entity.Department;
import com.wjb.oa.entity.Employee;

public interface DepartmentDao {
    public Department selectById(Long departmentId);
}
