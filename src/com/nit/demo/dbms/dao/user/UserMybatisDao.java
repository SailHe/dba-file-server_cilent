package com.nit.demo.dbms.dao.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.nit.demo.dbms.model.UserBean;
import com.nit.demo.dbms.util.DMUtil;

/**
 * Descriptions: 使用Mybatis实现的用户访问对象(DAO)<p>
 *
 * @author Unknown
 * @date 2018/11/15 17:28
 */
public class UserMybatisDao implements UserDaoInterface {

    @Override
    public List<UserBean> getUserByLoginName(String loginName, Integer loginType) {
        SqlSessionFactory sessionFactory = null;
        SqlSession session = null;
        List<UserBean> listUser = new ArrayList<>();
        try {
            sessionFactory = DMUtil.getConn();
            // 创建Session
            session = sessionFactory.openSession();
            //映射sql的标识字符串
            String msql = "com.nit.dbms.action.dao.UserMapper.getUserByLoginName";
            //执行查询返回一个唯一user对象的sql
            listUser = session.selectList(msql, loginName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库实例
            DMUtil.closeConn(session, sessionFactory);
        }
        return listUser;
    }

    @Override
    public List<UserBean> getUserInfo() {
        SqlSessionFactory sessionFactory = null;
        SqlSession session = null;
        List<UserBean> listUser = new ArrayList<>();
        try {
            sessionFactory = DMUtil.getConn();
            // 创建Session
            session = sessionFactory.openSession();
            //映射sql的标识字符串
            String msql = "com.nit.dbms.action.dao.UserMapper.getUserInfo";
            //执行查询返回一个唯一user对象的sql
            listUser = session.selectList(msql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库实例
            DMUtil.closeConn(session, sessionFactory);
        }
        return listUser;
    }
}
