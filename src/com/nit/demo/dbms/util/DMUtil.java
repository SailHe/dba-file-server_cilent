package com.nit.demo.dbms.util;

import java.io.InputStream;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Descriptions: Mybatis的连接工具<p>
 * 需要mybatis-*.jar
 *
 * @date 2018/11/12 23:01
 */
public class DMUtil {

    // 获得与指定数据库的连接
    public static SqlSessionFactory getConn() throws SQLException, ClassNotFoundException {

        // mybatis的配置文件
        String resource = "mybatis.xml";
        // 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = DMUtil.class.getClassLoader().getResourceAsStream(resource);
        // 构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        // Reader reader = Resources.getResourceAsReader(resource);
        // 构建sqlSession的工厂
        // SqlSessionFactory sessionFactory = new
        // SqlSessionFactoryBuilder().build(reader);
        // 创建能执行映射文件中sql的sqlSession
        // SqlSession session = sessionFactory.openSession();
        return sessionFactory;
    }

    // 释放资源，关闭数据库连接
    public static void closeConn(SqlSession session, SqlSessionFactory sessionFactory) {
        try {
            if (session != null) {
                session.close();
            }
            session = null;
            if (sessionFactory != null) {
                sessionFactory = null;
            }
            System.out.println("数据库连接释放成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接释放失败！");
        }
    }
}
