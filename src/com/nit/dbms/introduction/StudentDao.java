package com.nit.dbms.introduction;

import com.nit.dbms.jdbc.DBConn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    // 插入操作
    public int insert(StudentBean student) {
        Connection conn = DBConn.getConn(); // 获取连接
        PreparedStatement prestmt = null; // 预编译语句集
        ResultSet rs = null; // 结果集
        int i = 0;
        try {
            //conn.setAutoCommit(false);
            //String sql = "insert into student(SId,GId,SName,SSexy,SBdate,STele) values(?,?,?,?,?,?)";
            String sql = "insert into student(GId,SName,SSexy,SBdate,STele) values(?,?,?,?,?)";
            prestmt = (PreparedStatement) conn.prepareStatement(sql);
            //prestmt.setString(1, student.getSId());
            prestmt.setString(1, student.getGId());
            prestmt.setString(2, student.getSName());
            prestmt.setString(3, student.getSSexy());
            prestmt.setString(4, student.getSBdate());
            prestmt.setString(5, student.getSTele());
            i = prestmt.executeUpdate();
            //conn.rollback();
            prestmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 注意要关闭连接及相关资源
            DBConn.closeConn(rs, null, prestmt, null, conn);
        }
        return i;
    }

    // 删除操作
    public int delete(String sName) {
        Connection conn = DBConn.getConn();
        Statement stmt = null;// 声明语句集
        int i = 0;
        String sql = "delete from student where SName='" + sName + "'";
        try {
            stmt = conn.createStatement();
            i = stmt.executeUpdate(sql);
            System.out.println("resutl: " + i);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 注意要关闭连接及相关资源
            DBConn.closeConn(null, stmt, null, null, conn);
        }
        return i;
    }

    // 更新操作
    public int update(StudentBean student) {
        Connection conn = DBConn.getConn();
        PreparedStatement prestmt = null;// 预编译语句集
        ResultSet rs = null;
        int i = 0;
        String sql = "update student set STele='" + student.getSTele() + "' where SName='" + student.getSName() + "'";
        try {
            prestmt = (PreparedStatement) conn.prepareStatement(sql);
            i = prestmt.executeUpdate();
            System.out.println("resutl: " + i);
            prestmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.closeConn(rs, null, prestmt, null, conn);
        }
        return i;
    }

    // 查询并直接显示到控制台
    public Integer getAll() {
        Connection conn = DBConn.getConn();
        PreparedStatement prestmt = null;// 预编译语句集
        ResultSet rs = null;
        String sql = "select * from student";
        try {
            prestmt = (PreparedStatement) conn.prepareStatement(sql);
            rs = prestmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            System.out.println("============================");
            while (rs.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println("");
            }
            System.out.println("============================");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.closeConn(rs, null, prestmt, null, conn);
        }
        return null;
    }

    // 查询并转换为List数据结构
    public List<StudentBean> getStudentInfo(String strQuery) {
        Connection conn = DBConn.getConn();
        PreparedStatement prestmt = null;
        ResultSet rs = null;
        List<StudentBean> listStudent = new ArrayList<StudentBean>();
        String sql = "select * from student where SName like '%" + strQuery + "%'";
        try {
            prestmt = (PreparedStatement) conn.prepareStatement(sql);
            rs = prestmt.executeQuery();
            StudentBean studentBean = null;
            while (rs.next()) {
                studentBean = new StudentBean();
                studentBean.setSId(rs.getString(1));
                studentBean.setSName(rs.getString(3));
                studentBean.setSSexy(rs.getString(4));
                studentBean.setSBdate(rs.getString(5));
                studentBean.setSTele(rs.getString(6));
                listStudent.add(studentBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.closeConn(rs, null, prestmt, null, conn);
        }
        return listStudent;
    }
}
