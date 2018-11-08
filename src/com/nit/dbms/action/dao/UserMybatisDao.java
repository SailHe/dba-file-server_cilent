package com.nit.dbms.action.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.nit.dbms.action.model.UserBean;
import com.nit.dbms.action.mybatis.User;
import com.nit.dbms.action.mybatis.UserMapper;
import com.nit.dbms.action.util.DMUtil;

public class UserMybatisDao {
	
	public List<UserBean> getUserByLoginName(String loginName, Integer loginType) {
		SqlSessionFactory  sessionFactory = null;
		SqlSession session = null;
		List<UserBean> listUser = new ArrayList<UserBean>();
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

	public List<UserBean> getUserInfo() {
		SqlSessionFactory  sessionFactory = null;
		SqlSession session = null;
		List<UserBean> listUser = new ArrayList<UserBean>();
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
