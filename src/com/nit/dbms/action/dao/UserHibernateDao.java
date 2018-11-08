package com.nit.dbms.action.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.nit.dbms.action.model.UserBean;
import com.nit.dbms.action.util.DHUtil;

public class UserHibernateDao {
	@SuppressWarnings("unchecked")
	public List<UserBean> getUserByLoginName(String loginName, Integer loginType) {
		SessionFactory sessionFactory = null;
		Session session = null;
		List<UserBean> listUser = new ArrayList<UserBean>();
		try {
			sessionFactory = DHUtil.getConn();
			String hql = "from UserBean where loginName = :loginName";
			// 创建Session
			session = sessionFactory.openSession();
			// 开始事务
			Transaction transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setString("loginName", loginName);
			// 提交事物
			transaction.commit();
			listUser = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库实例
			DHUtil.closeConn(session, sessionFactory);
		}
		return listUser;
	}

	// 得到用户所有信息，用于选择发送人
	@SuppressWarnings("unchecked")
	public List<UserBean> getUserInfo() {
		SessionFactory sessionFactory = null;
		Session session = null;
		List<UserBean> listUser = new ArrayList<UserBean>();
		try {
			sessionFactory = DHUtil.getConn();
			String hql = "from UserBean";
			session = sessionFactory.openSession();
			Query query = session.createQuery(hql);
			listUser = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库实例
			DHUtil.closeConn(session, sessionFactory);
		}
		return listUser;
	}
}
