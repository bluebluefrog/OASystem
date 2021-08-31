package com.wjb.oa.utils;

import org.junit.Test;

public class MyBatisUtilsTestor {
    @Test
    public void testcase1() {
        String result=(String)MyBatisUtils.executeQuery(sqlSession -> {
            String str = sqlSession.selectOne("test.sample");
            return str;
        });
        System.out.println(result);
    }
}
