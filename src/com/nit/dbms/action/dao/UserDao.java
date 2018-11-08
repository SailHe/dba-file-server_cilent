package com.nit.dbms.action.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nit.dbms.action.model.UserBean;
import com.nit.dbms.action.util.DBUtil;
import com.nit.dbms.action.util.DCUtil;
import com.nit.dbms.action.util.DPUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDao {
    // 采用三种方式根据登录名称得到用户所有信息
    public List<UserBean> getUserByLoginName(String loginName, Integer loginType) {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement prestmt = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        String sql = "";
        List<UserBean> listUser = new ArrayList<UserBean>();

        try {
            //使用不同的连接方式
            conn = DPUtil.getConn();
            conn.setAutoCommit(false);
            if (loginType.equals(1)) {
                // 通过语句集的方式进行查询
                sql = "select * from tb_user where login_name='" + loginName + "'";
                // sql = "select * from tb_user where login_name like '" + loginName + "'";
                System.out.println(sql);
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
            } else if (loginType.equals(2)) {
                // 通过预编译语句集的方式进行查询
                sql = "select * from tb_user where login_name = ?";
                prestmt = conn.prepareStatement(sql);
                prestmt.setString(1, loginName);
                rs = prestmt.executeQuery();
            } else {
                // 通过调用存储过程进行查询
                sql = "call proc_login(?)";
                cstmt = conn.prepareCall("{" + sql + "}");
                cstmt.setString(1, loginName);
                rs = cstmt.executeQuery();
            }
            conn.commit();
            // 从数据集类型转化为List数据结构
            UserBean userBean = null;
            while (rs.next()) {
                userBean = new UserBean();
                userBean.setUserId(Integer.parseInt(rs.getString(1)));
                userBean.setLoginName(rs.getString(2));
                userBean.setLoginPwd(rs.getString(3));
                userBean.setUserName(rs.getString(4));
                userBean.setUserSex(rs.getString(5));
                listUser.add(userBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库实例
            DPUtil.closeConn(rs, stmt, prestmt, cstmt, conn);
        }
        return listUser;
    }

    // 得到用户所有信息
    public List<UserBean> getUserInfo() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<UserBean> listUser = new ArrayList<UserBean>();

        try {
            //使用不同的连接方式
            conn = DBUtil.getConn();
            String sql = "select user_id, login_name, user_name from tb_user";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            // 从数据集类型转化为List数据结构
            UserBean userBean = null;
            while (rs.next()) {
                userBean = new UserBean();
                userBean.setUserId(Integer.parseInt(rs.getString(1)));
                userBean.setUserName(rs.getString(3));
                listUser.add(userBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库实例
            DBUtil.closeConn(rs, stmt, null, null, conn);
        }
        return listUser;
    }
}
