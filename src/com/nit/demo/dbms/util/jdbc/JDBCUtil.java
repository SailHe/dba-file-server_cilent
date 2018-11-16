package com.nit.demo.dbms.util.jdbc;

import java.sql.*;

/**
 * Descriptions: JDBC 的连接工具<p>
 *
 * 2825 2710 2671 2705
 * @date 2018/11/12 23:01
 */
public class JDBCUtil {
    // 加载数据库驱动
    static {
        try {
            Class.forName(JDBCConfig.DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Descriptions: 获取数据库连接<p>
     *
     * @author Unknown
     * @date 2018/11/16 13:54
     */
    public static Connection getConn() {
        try {
            System.out.println("数据库连接创建成功！");
            return DriverManager.getConnection(
                    JDBCConfig.DB_URL, JDBCConfig.USER_NAME, JDBCConfig.USER_PWD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接创建失败！");
        }
        return null;
    }

    /**
     * Descriptions: 释放资源，关闭数据库连接<p>
     *
     * @author Unknown
     * @date 2018/11/16 13:53
     */
    public static void closeConn(ResultSet rs, Statement stmt, PreparedStatement prestmt
            , CallableStatement callStmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            rs = null;
            if (stmt != null) {
                stmt.close();
            }
            stmt = null;
            if (prestmt != null) {
                prestmt.close();
            }
            prestmt = null;
            if (callStmt != null) {
                callStmt.close();
            }
            callStmt = null;
            if (conn != null) {
                conn.close();
            }
            conn = null;
            System.out.println("数据库连接释放成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接释放失败！");
        }
    }
}
