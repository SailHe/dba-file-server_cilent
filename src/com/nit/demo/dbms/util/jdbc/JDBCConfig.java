package com.nit.demo.dbms.util.jdbc;

/**
 * Description: 无描述类<p>
 *
 * @Package: com.nit.dbms.introduction
 * @author: SailHe
 * @date: 2018/11/8 15:53
 */
public class JDBCConfig {
    /**
     * Descriptions: 定义MySQL数据库连接信息<p>
     *
     * @author SailHe
     * @date 2018/11/16 13:21
     */
    public final static String DRIVER_NAME = "com.mysql.jdbc.Driver";
    /**
     * Descriptions: 指定字符的编码、解码格式。的数据库连接字符串<p>
     *
     * @author SailHe
     * @date 2018/11/16 13:29
     */
    public final static String DB_URL = "jdbc:mysql://127.0.0.1:3306/jiaowu_schema?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    public final static String USER_NAME = "sailhe";
    public final static String USER_PWD = "123456@password";
}
