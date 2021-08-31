package com.wjb.oa.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import javax.sql.DataSource;
import java.sql.SQLException;

//首先要继承UnpooledDataSourceFactory
public class DruidDataSourceFactory extends UnpooledDataSourceFactory {
    //重写方法来完成对数据源的创建
    public DruidDataSourceFactory(){
        //DruidDataSource是阿里巴巴提供的数据源类，，哪些连接信息
        //this.dataSource
        this.dataSource = new DruidDataSource();
    }
    //对父类中的方法进行重写
    @Override
    public DataSource getDataSource(){
        //这里的DataSource有JDBC提供的接口，所有的数据源都要实现该接口
        try {
            ((DruidDataSource) this.dataSource).init();//转换成原始的数据源类型DruidDataSource并初始化数据源
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
        //实际返回的类型返回的是DruidDataSource
        return this.dataSource;
    }
}
