package com.atmae.card.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {

    public static DruidDataSource druidDataSource;

    //静态代码块初始化
    static {
        try {
            Properties pros = new Properties();
            //读取jdbc.properties属性文件
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            pros.load(is);
            //创建数据库连接池
            druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(pros);
            DruidPooledConnection connection = druidDataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取数据库连接池中的连接
     * 返回null 获取连接失败
     */
    public static Connection getConnection() {

        Connection connection = null;

        try {
            connection = druidDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭连接放回数据库连接池
     *
     * @param connection
     */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
