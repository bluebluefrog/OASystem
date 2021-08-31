package com.wjb.oa.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.function.Function;

public class MyBatisUtils {
    //首先声明空SqlSessionFactory
    private static SqlSessionFactory sqlSessionFactory=null;
    //使用静态代码块可以让SqlSessionFactory在类初始化时就自动创建出来
    static {
        Reader reader = null;
        try {
            //先读取到mybatis配置文件
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            //将SqlSessionFactory new出来, 江都区的配置文件流传入到SqlSessionFactoryBuilder().build中会自动创建SqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            //抛初始化异常
            throw new ExceptionInInitializerError(e);
        }
    }

    //数据查询和数据写入

    //数据查询
    //此处参数使用函数试接口
    public static Object executeQuery(Function<SqlSession,Object> func){
        //使用sqlSessionFactory.openSession()得到SqlSession进行mybatis对数据库的操作

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //使用函数试接口进行apply执行操作
        try {
            Object obj = func.apply(sqlSession);
            return obj;
        }finally {
            //保证sqlSession.close(),因为finally一定会被执行
            sqlSession.close();
        }
    }

    //数据写入
    public static Object updateQuery(Function<SqlSession,Object> func){
        //使用sqlSessionFactory.openSession()得到SqlSession进行mybatis对数据库的操作

        SqlSession sqlSession = sqlSessionFactory.openSession(false);//将自动提交设置为false
        //使用函数试接口进行apply执行操作
        try {
            Object obj = func.apply(sqlSession);
            //成功则提交
            sqlSession.commit();
            return obj;
        }catch(RuntimeException e){
            //出现异常则rollback
            sqlSession.rollback();
            throw e;
        }finally {
            //保证sqlSession.close(),因为finally一定会被执行
            sqlSession.close();
        }
    }

}
