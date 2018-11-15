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
 * @date 2018/11/12 23:01
 */
public class DHUtil {

    // 获得与指定数据库的连接
    public static SessionFactory getConn() throws SQLException, ClassNotFoundException {
        SessionFactory sessionFactory = null;
        // 不带参数的configure方法将默认加载hibernate.cfg.xml文件
        Configuration configuration = new Configuration().configure();
        // 通过addAnnotatedClass方法添加已经注解的持久化类
        configuration.addAnnotatedClass(com.nit.demo.dbms.model.UserBean.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        // 以Configuration实例创建SessionFactory实例
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
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
