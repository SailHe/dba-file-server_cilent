package com.nit.demo.dbms.dao.user;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.nit.demo.dbms.model.UserBean;
import com.nit.demo.dbms.util.DHUtil;

/**
 * Descriptions: 使用Hibernate实现的用户访问对象(DAO)<p>
 *
 * @author Unknown
 * @date 2018/11/15 17:28
 */
public class UserHibernateDao implements UserDaoInterface {
    @Override
    @SuppressWarnings("unchecked")
    public List<UserBean> getUserByLoginName(String loginName, Integer loginType) {
        SessionFactory sessionFactory = null;
        Session session = null;
        List<UserBean> listUser = new ArrayList<>();
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

    @Override
    @SuppressWarnings("unchecked")
    public List<UserBean> getUserInfo() {
        SessionFactory sessionFactory = null;
        Session session = null;
        List<UserBean> listUser = new ArrayList<>();
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
