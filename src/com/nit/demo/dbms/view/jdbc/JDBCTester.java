package com.nit.demo.dbms.view.jdbc;

import com.nit.demo.dbms.dao.student.StudentDao;

public class JDBCTester {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        /*for (int i = 0; i < 10; i++) {
            studentDao.insert(new StudentBean("01700500" + i, "01", "张三丰", "男", "1997-10-11 00:00:00", "660780"));
        }*/
        studentDao.getAll();
        //studentDao.update(new StudentBean("", "", "张三丰", "", "", "666666"));
        //studentDao.getAll();
        //studentDao.delete("张三丰");
        //studentDao.getAll();
    }
}
