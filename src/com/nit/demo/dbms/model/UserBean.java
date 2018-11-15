package com.nit.demo.dbms.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "tb_user", catalog = "jiaowu_schema")
public class UserBean implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer userId;
    private String loginName;
    private String loginPwd;
    private String userName;
    private String userSex;

    public UserBean() {
    }

    public UserBean(Integer userId, String loginName, String loginPwd, String userName, String userSex) {
        this.userId = userId;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.userName = userName;
        this.userSex = userSex;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name="login_name")
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Column(name="login_pwd")
    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    @Column(name="user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name="user_sex")
    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }
}
