package com.nit.dbms.action.util;

import com.nit.dbms.introduction.ProjectConstant;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//需要proxool-0.9.1.jar和proxool-cglib.jar和commons-logging-1.2.jar
public class DPUtil {

	// 定义MySQL数据库连接信息
	private final static String driverName = "org.logicalcobwebs.proxool.ProxoolDriver";
	private final static String dbURL = "proxool.mysql:com.mysql.jdbc.Driver:jdbc:mysql://127.0.0.1:3306/jiaowu_schema?useSSL=false";
	private final static String userName = "root";
	private final static String userPwd = ProjectConstant.dbaPass;

	// 获得与指定数据库的连接
	public static Connection getConn() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		Properties info = new Properties();
		info.setProperty("user", userName);
		info.setProperty("password", userPwd);
		info.setProperty("proxool.alias", "mysql");
		info.setProperty("proxool.maximum-connection-count", "20");
		info.setProperty("proxool.minimum-connection-count", "10");
		info.setProperty("proxool.house-keeping-test-sql", "select CURRENT_DATE");
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL,info);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 释放资源，关闭数据库连接
	public static void closeConn(ResultSet rs, Statement stmt, PreparedStatement prestmt, CallableStatement cstmt,
			Connection conn) {
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
