package com.nit.demo.dbms.dao.user;

import com.nit.demo.dbms.model.UserBean;

import java.util.List;

/**
 * Description: 无描述类<p>
 *
 * @Package: com.nit.dbms.database.dao
 * @author: SailHe
 * @date: 2018/11/15 17:24
 */
public interface UserDaoInterface {
    /**
     * Descriptions: 采用三种方式根据登录名称得到用户所有信息<p>
     *
     * @author SailHe
     * @date 2018/11/15 17:24
     */
    List<UserBean> getUserByLoginName(String loginName, Integer loginType);

    /**
     * Descriptions: 得到用户所有信息<p>
     *
     * @author SailHe
     * @date 2018/11/15 17:24
     */
    List<UserBean> getUserInfo();
}
