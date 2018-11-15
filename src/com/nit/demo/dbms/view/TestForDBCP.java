package com.nit.demo.dbms.view;

import com.nit.demo.dbms.dao.user.UserDao;
import com.nit.demo.dbms.model.UserBean;

import java.util.List;

/**
 * Descriptions: 用于测试连接池<p>
 *
 * @author Unknown||Hidden
 * @date 2018/11/15 17:10
 */
public class TestForDBCP {
	public static void main(String[] srg) {
		java.util.Date startTime = new java.util.Date();
		for (int k = 0; k < 200; k++) {
			// 初始化一个用户实例
			UserDao userDao = new UserDao();
			//UserHibernateDao userDao = new UserHibernateDao();
			//UserMybatisDao userDao = new UserMybatisDao();
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
}
