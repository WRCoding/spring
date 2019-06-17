package com.lb.utils;

import javax.sql.DataSource;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author LB
 * @create 2019-06-16 16:08
 */
public class ConnectionUtils {
    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getConnection(){
        //1.先从ThreadLocal上获取
        try {
            Connection conn = threadLocal.get();
            //2.判断当前线程上是否有连接
            if(null == conn){
                //3.从数据源中获取一个链接
                conn = dataSource.getConnection();
                threadLocal.set(conn);
            }
            //4.返回当前线程上的连接
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 把连接和线程解绑
     */
    public void remove(){
        threadLocal.remove();
    }
}
