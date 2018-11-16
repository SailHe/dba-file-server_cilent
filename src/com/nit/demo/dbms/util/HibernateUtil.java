package com.nit.demo.dbms.util;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Descriptions: Hibernate的连接工具<p>
 * 需要hibernate-*.jar,jboss-*.jar,org.apache.geronimo-jta-*.jar,dom4j-*.jar,antlr-*.jar,javassist-*.jar
 *
 * 目前, Proxool和DBCP以及C3P0一起，最为常见的三种JDBC连接池技术。
 * Hibernate官方宣布由于Bug太多不再支持DBCP，而推荐使用 Proxool或C3P0。
 *
 * @date 2018/11/12 23:01
 */
public class HibernateUtil {

    private static Configuration configuration;
    private static ServiceRegistry serviceRegistry;
    /**
     * Descriptions: SessionFactory 可以创建并打开新的 Session。
     *         一个 Session 代表一个单线程的单元操作，
     *         org.hibernate.SessionFactory 则是个线程安全的全局对象，只需要被实例化一次。<p>
     *
     * @author SailHe
     * @date 2018/11/16 14:55
     */
    private static SessionFactory sessionFactory;

    static {
        // 不带参数的configure方法将默认加载hibernate.cfg.xml文件
        configuration = new Configuration().configure();
        // 通过addAnnotatedClass方法添加已经注解的持久化类
        configuration.addAnnotatedClass(com.nit.demo.dbms.model.UserBean.class);
        serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        // 以Configuration实例创建SessionFactory实例
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    // 获得与指定数据库的连接
    public static SessionFactory getConnOld() throws SQLException, ClassNotFoundException {
        return sessionFactory;
    }

    public static Session getConn() throws ClassNotFoundException {
        //返回“当前的”工作单元
        //sessionFactory.getCurrentSession();
        return sessionFactory.openSession();
    }

    // 释放资源，关闭数据库连接
    public static void closeConn(Session session, SessionFactory sessionFactory) {
        try {
            if (session != null) {
                session.close();
            }
            session = null;
            if (sessionFactory != null) {
                sessionFactory.close();
            }
            sessionFactory = null;
            System.out.println("数据库连接释放成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接释放失败！");
        }
    }
}
