package com.nit.demo.dbms.util.jdbc.dbcp;

import java.beans.PropertyVetoException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nit.demo.dbms.util.jdbc.JDBCConfig;
import com.nit.demo.dbms.util.jdbc.JDBCUtil;

/**
 * Descriptions: c3p 的连接工具<p>
 * 需要c3p0-0.9.2.1.jar和mchange-commons-java-0.2.3.4,jar
 * <p>
 * C3P0是一个开源的JDBC连接池，它实现了数据源和JNDI绑定，支持JDBC3规范和JDBC2的标准扩展。
 * c3p0是异步操作的，缓慢的JDBC操作通过帮助进程完成。扩展这些操作可以有效的提升性能。
 * 目前使用它的开源项目有hibernate，spring等。
 * 是一个成熟的、高并发的JDBC连接池库，用于缓存和重用PreparedStatements支持。
 * c3p0具有自动回收空闲连接功能。
 *
 * @date 2018/11/12 23:01
 */
public class C3p0Util {
    //定义数据库连接池
    private static DataSource ds;

    // 加载数据库驱动，初始化c3p0连接池
    static {
        try {
            ComboPooledDataSource cpds = new ComboPooledDataSource();
            cpds.setDriverClass(JDBCConfig.DRIVER_NAME);
            cpds.setJdbcUrl(JDBCConfig.DB_URL);
            cpds.setUser(JDBCConfig.USER_NAME);
            cpds.setPassword(JDBCConfig.USER_PWD);
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

    public static Connection getConn() throws SQLException {
        // 从连接池返回一个连接
        return ds.getConnection();
    }

    public static void closeConn(ResultSet rs, Statement stmt, PreparedStatement prestmt
            , CallableStatement cstmt, Connection conn) {
        JDBCUtil.closeConn(rs, stmt, prestmt, cstmt, conn);
    }
}
