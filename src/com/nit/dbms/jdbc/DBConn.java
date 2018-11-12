package com.nit.dbms.jdbc;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DBConn {
    // 定义MySQL数据库连接信息
    private final static String driverName = "com.mysql.jdbc.Driver";
    private final static String dbURL = "jdbc:mysql://127.0.0.1:3306/jiaowu_schema?characterEncoding=utf8&useSSL=false";
    private final static String userName = "sailhe";
    private final static String userPwd = ProjectConstant.dbaPass;

    // 加载数据库驱动
    static {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 获取数据库连接
    public static Connection getConn() {
        try {
            System.out.println("数据库连接创建成功！");
            return DriverManager.getConnection(dbURL, userName, userPwd);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接创建失败！");
        }
        return null;
    }

    // 释放资源，关闭数据库连接
    public static void closeConn(ResultSet rs, Statement stmt
            , PreparedStatement prestmt, CallableStatement cstmt, Connection conn) {
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
