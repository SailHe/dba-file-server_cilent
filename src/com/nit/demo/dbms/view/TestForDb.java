package com.nit.demo.dbms.view;

import com.nit.demo.dbms.dao.user.UserDao;
import com.nit.demo.dbms.dao.user.UserDaoInterface;
import com.nit.demo.dbms.model.UserBean;

import java.util.List;

/**
 * Descriptions: 用于 连接池 测试<p>
 *
 * @author Unknown||Hidden
 * @date 2018/11/15 17:10
 */
public class TestForDb {

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

        //数据库连接池效率比较

        //Druid 1499 1767 1435 1934 1615           avl:1650
        //C3p0: 2336 2642 2388 2541                avl:2476.75   2031 2352
        //JDBC 2560 2508 2487 2535                 avl:2522.5
        //Proxool 2999 2870 2819 2713 2690         avl:2818.2
        test(new UserDao());

        //持久层框架效率比较

        //更改session获取方法之前(34536 36124)        avl:35330
        // -> 更改之后(4879 5094 5284 4924)          avl:5045.25
        //test(new UserHibernateDao());

        //8030 8342 7828 7493 7674                 avl:7873.4
        //test(new UserMybatisDao());

	}
}
