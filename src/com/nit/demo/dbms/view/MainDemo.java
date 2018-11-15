package com.nit.demo.dbms.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import com.nit.demo.dbms.dao.user.UserDao;
import com.nit.demo.dbms.model.UserBean;

public class MainDemo extends JFrame {

    private static final long serialVersionUID = 1L;
    // 程序主框架
    private JFrame jFrame;
    // 主面板
    private JPanel jPanel;
    // 发送消息按钮
    private JButton jButtonSend;
    // 消息内容文本框
    private JTextField jTextMessage;
    // 发送对象选择列表
    private JComboBox<Map> jComboBoxReceiver;


    public MainDemo(Integer userId, String userName) {
        jTextMessage = new JTextField("消息内容");
        jComboBoxReceiver = new JComboBox<Map>();
        jButtonSend = new JButton("发 送");
        jPanel = new JPanel();
        // 定义整体菜单面板布局
        JPanel jPanelMenu = new JPanel();
        jPanelMenu.setLayout(new GridLayout(1, 3));
        jPanelMenu.add(jTextMessage);
        jPanelMenu.add(jComboBoxReceiver);
        jPanelMenu.add(jButtonSend);
        // 添加列表
        jPanel.setLayout(new BorderLayout());
        jPanel.add(jPanelMenu, BorderLayout.CENTER);
        // 定义主界面框架
        jFrame = new JFrame(userName + " 你好！");
        // 设置显示大小及位置等属性
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int SwingX = 400;
        int SwingY = 60;
        jFrame.setBounds(screensize.width / 2 - SwingX / 2, screensize.height / 2 - SwingY / 2, SwingX, SwingY);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = jFrame.getContentPane();
        contentPane.add(jPanel, BorderLayout.CENTER);
        jFrame.setResizable(false);
        jFrame.setVisible(true);

        // 初始化用户对象实例，为发送对象下拉列表框赋值
        UserDao userDao = new UserDao();
        List<UserBean> listUser = new ArrayList<UserBean>();
        listUser = userDao.getUserInfo();
        UserBean userBean = new UserBean();
        for (int i = 0; i < listUser.size(); i++) {
            userBean = listUser.get(i);
            Map<Integer, String> userMap = new HashMap();
            userMap.put(userBean.getUserId(),userBean.getUserName());
            jComboBoxReceiver.addItem(userMap);
        }
    }
}
