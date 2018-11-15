package com.nit.demo.dbms.util;

import java.beans.PropertyVetoException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Descriptions: c3p 的连接工具<p>
 * 需要c3p0-0.9.2.1.jar和mchange-commons-java-0.2.3.4,jar
 *
 * @date 2018/11/12 23:01
 */
public class DCUtil {

    // 定义MySQL数据库连接信息
    private final static String driverName = "com.mysql.jdbc.Driver";
    private final static String dbURL = "jdbc:mysql://127.0.0.1:3306/jiaowu_schema?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    private final static String userName = "sailhe";
    private final static String userPwd = ProjectConstant.DBA_PASSWORD;
    //定义数据库连接池
    private static DataSource ds;

    // 加载数据库驱动，初始化c3p0连接池
    static {
        try {
            ComboPooledDataSource cpds = new ComboPooledDataSource();
            cpds.setDriverClass(driverName);
            cpds.setJdbcUrl(dbURL);
            cpds.setUser(userName);
            cpds.setPassword(userPwd);
            cpds.setAcquireIncrement(5);
            cpds.setInitialPoolSize(5);
            cpds.setMinPoolSize(3);
            cpds.setMaxPoolSize(20);
            cpds.setMaxStatements(0);
            cpds.setMaxStatementsPerConnection(5);
            ds = cpds;
        } catch (PropertyVetoException e) {
            System.out.println("数据源属性不匹配！");
        }
    }

    // 获取与指定数据的连接
    public static DataSource getSource() {
        return ds;
    }

    // 获得与指定数据库的连接
    public static Connection getConn() throws SQLException {
        // 从连接池返回一个连接
        return ds.getConnection();
    }

    // 释放资源，关闭数据库连接
    public static void closeConn(ResultSet rs, Statement stmt, PreparedStatement prestmt
            , CallableStatement cstmt, Connection conn) {
        try {
            if (rs != null)
                rs.close();
            rs = null;
            if (stmt != null)
                stmt.close();
            stmt = null;
            if (prestmt != null)
                prestmt.close();
            prestmt = null;
            if (cstmt != null)
                cstmt.close();
            cstmt = null;
            if (conn != null)
                conn.close();
            conn = null;
            System.out.println("数据库连接释放成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接释放失败！");
        }
    }
}
