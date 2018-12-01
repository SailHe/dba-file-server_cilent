package com.nit.demo.dbms.util.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.nit.demo.dbms.util.jdbc.JDBCUtil;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Descriptions: 阿里的数据库连接池工具类<p>
 *
 * @author SailHe
 * @date 2018/12/1 18:12
 */
public class DruidUtil {

    private static DataSource dataSource;

    static {
        try {
            dataSource = DruidDataSourceFactory
                    .createDataSource(
                            new PropertyConfig("dbconfig.properties")
                            .getProperties()
                    );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final DataSource getDataSource() throws Exception {

        return dataSource;
    }

    public static Connection getConn() throws SQLException {
        // 从连接池返回一个连接
        return dataSource.getConnection();
    }

    public static void closeConn(ResultSet rs, Statement stmt, PreparedStatement prestmt
            , CallableStatement cstmt, Connection conn) {
        JDBCUtil.closeConn(rs, stmt, prestmt, cstmt, conn);
    }

}
