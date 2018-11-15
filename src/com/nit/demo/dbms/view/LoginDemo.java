package com.nit.demo.dbms.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.nit.demo.dbms.dao.user.UserDao;
import com.nit.demo.dbms.model.UserBean;


//登录界面
public class LoginDemo extends JFrame {

    private static final long serialVersionUID = 1L;
    // 定义文本框组件
    private JTextField jTextField;
    // 定义密码框组件
    private JPasswordField jPwdField;
    // 提示信息
    private JLabel jLabeCode, jLabelPwd;
    // 创建按钮
    private JButton jButtonLogin, jButtonCancel;
    // 面板容器
    private JPanel jPanelTop, jPanelMiddle, jPanelBottom;
    // 创建主框架容器
    private JFrame jFrame;

    public LoginDemo() {
        // 设置文本框宽度
        jTextField = new JTextField(15);
        jPwdField = new JPasswordField(15);
        jLabeCode = new JLabel("用户名：");
        jLabelPwd = new JLabel("密    码：");
        jButtonLogin = new JButton("确 认");
        jButtonCancel = new JButton("取 消");
        jPanelTop = new JPanel();
        jPanelMiddle = new JPanel();
        jPanelBottom = new JPanel();
        // 第一块面板添加用户名和文本框
        jPanelTop.add(jLabeCode);
        jPanelTop.add(jTextField);
        // 第二块面板添加密码和密码输入框
        jPanelMiddle.add(jLabelPwd);
        jPanelMiddle.add(jPwdField);
        // 第三块面板添加确认和取消
        jPanelBottom.add(jButtonLogin);
        jPanelBottom.add(jButtonCancel);
        // 定义主界面框架
        jFrame = new JFrame("用户登录");
        // 设置布局
        jFrame.setLayout(new GridLayout(3, 1, 20, 20));
        // 将三块面板添加到登陆框上面
        jFrame.add(jPanelTop);
        jFrame.add(jPanelMiddle);
        jFrame.add(jPanelBottom);
        // 设置显示大小及位置等属性
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int SwingX = 300;
        int SwingY = 200;
        jFrame.setBounds(screensize.width / 2 - SwingX / 2, screensize.height / 2 - SwingY / 2, SwingX, SwingY);
        jFrame.setSize(SwingX, SwingY);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setVisible(true);

        // 登录按钮单击事件的业务逻辑
        jButtonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 数据库验证操作，初始化一个用户实例
                UserDao userDao = new UserDao();
                List<UserBean> listUser = new ArrayList<UserBean>();
                listUser = userDao.getUserByLoginName(jTextField.getText(), 2);
                if (listUser == null || listUser.size() == 0) {
                    // 弹出消息提示框
                    JOptionPane.showMessageDialog(null, "对不起，该用户不存在，请重新输入！");
                } else {
                    UserBean userBean = new UserBean();
                    userBean = listUser.get(0);
                    // 密码输入框的编码转换
                    char[] passwords = jPwdField.getPassword();
                    if (userBean.getLoginPwd().equals(new String(passwords))) {
                        // 进入消息显示对话框
                        jFrame.dispose();
                        new MainDemo(userBean.getUserId(), userBean.getUserName());
                    } else {
                        JOptionPane.showMessageDialog(null, "对不起，密码错误，请重新输入！");
                    }
                }
            }
        });

        // 取消按钮单击事件
        jButtonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
            }
        });
    }

    public static void main(String[] args) {
        new LoginDemo();
    }
}
