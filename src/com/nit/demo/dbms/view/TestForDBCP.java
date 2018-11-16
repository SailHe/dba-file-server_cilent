package com.nit.demo.dbms.view;

import com.nit.demo.dbms.dao.user.UserDao;
import com.nit.demo.dbms.dao.user.UserDaoInterface;
import com.nit.demo.dbms.dao.user.UserHibernateDao;
import com.nit.demo.dbms.dao.user.UserMybatisDao;
import com.nit.demo.dbms.model.UserBean;

import java.util.List;

/**
 * Descriptions: 用于 连接池 测试<p>
 *
 * @author Unknown||Hidden
 * @date 2018/11/15 17:10
 */
public class TestForDBCP {

    private static void test(UserDaoInterface userDao){
        java.util.Date startTime = new java.util.Date();
        int testCnt = 200;
        for (int k = 0; k < testCnt; ++k) {
            List<UserBean> listUser = userDao.getUserByLoginName("ln",1);
            UserBean userBean;
            System.out.println(k + "————————————————————————————————");
            for (int i = 0; i < listUser.size(); i++) {
                userBean = listUser.get(i);
                System.out.print(" | ");
                System.out.print(userBean.getUserId() + " | ");
                System.out.print(userBean.getLoginName() + " | ");
                System.out.print(userBean.getUserName() + " | ");
                System.out.println(userBean.getUserSex() + " | ");
                System.out.println(k + "————————————————————————————————");
            }
        }
        java.util.Date endTime = new java.util.Date();
        long m = endTime.getTime() - startTime.getTime();
        System.out.println("数据库操作毫秒数:" + m);
    }

	public static void main(String[] srg) {
        // 初始化用户实例进行测试
        //test(new UserDao());
        //34536 36124
        test(new UserHibernateDao());
        //test(new UserMybatisDao());
	}
}
