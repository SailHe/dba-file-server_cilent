package com.nit.demo.dbms.util.jdbc.dbcp;

import com.nit.demo.dbms.util.jdbc.JDBCConfig;
import com.nit.demo.dbms.util.jdbc.JDBCUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Descriptions: proxool的连接工具<p>
 * 需要proxool-0.9.1.jar和proxool-cglib.jar和commons-logging-1.2.jar
 *
 * Proxool是一种Java数据库连接池技术。sourceforge下的一个开源项目,
 * 这个项目提供一个健壮、易用的连接池，最为关键的是这个连接池提供监控的功能，方便易用，便于发现连接泄漏的情况。
 *
 * @date 2018/11/12 23:01
 */
public class ProxoolUtil {

    /**
     * Descriptions: 定义Proxool的MySQL数据库连接信息<p>
     *
     * @author SailHe
     * @date 2018/11/16 13:51
     */
    private final static String DRIVER_NAME = "org.logicalcobwebs.proxool.ProxoolDriver";

    public static Connection getConn() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Properties info = new Properties();
        info.setProperty("user", JDBCConfig.USER_NAME);
        info.setProperty("password", JDBCConfig.USER_PWD);
        info.setProperty("proxool.alias", "mysql");
        info.setProperty("proxool.maximum-connection-count", "20");
        info.setProperty("proxool.minimum-connection-count", "10");
        info.setProperty("proxool.house-keeping-test-sql", "select CURRENT_DATE");
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(JDBCConfig.DB_URL, info);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConn(ResultSet rs, Statement stmt, PreparedStatement prestmt
            , CallableStatement cstmt, Connection conn) {
        JDBCUtil.closeConn(rs, stmt, prestmt, cstmt, conn);
    }
}
