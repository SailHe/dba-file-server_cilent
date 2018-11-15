package com.nit.demo.server;

import com.nit.demo.dbms.dao.MessageDao;
import com.nit.demo.dbms.dao.user.UserDao;
import com.nit.demo.dbms.model.Item;
import com.nit.demo.dbms.model.MessageBean;
import com.nit.demo.dbms.model.UserBean;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class MsgDemo_03 extends JFrame {

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
    private JComboBox<Item> jComboBoxReceiver;
    // 显示消息的滚动面板
    private JScrollPane jScrollPane;
    // 显示消息的表格，用于使界面显示更规则
    private JTable jTable;
    // 表格初始化模型
    private DBViewTableModel dbViewModel;
    // 消息变量初始化
    private List<MessageBean> listMessage = new ArrayList<MessageBean>();
    private MessageBean msgBean = new MessageBean();
    // 用于记录消息接收人
    Item item = null;
    // 用于记录我的ID
    Integer myId = 0;

    public MsgDemo_03(Integer userId, String userName) {
        jTextMessage = new JTextField("消息内容");
        jComboBoxReceiver = new JComboBox<Item>();
        jButtonSend = new JButton("发 送");
        // 滚动面板布局设置
        jScrollPane = new JScrollPane();
        jScrollPane.setPreferredSize(new Dimension(0, 440));
        jScrollPane.setViewportView(getMsgTable());
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
        jPanel.add(jScrollPane, BorderLayout.NORTH);
        // 定义主界面框架
        jFrame = new JFrame(userName + " 你好！");
        // 设置显示大小及位置等属性
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int SwingX = 600;
        int SwingY = 500;
        jFrame.setBounds(screensize.width / 2 - SwingX / 2, screensize.height / 2 - SwingY / 2, SwingX, SwingY);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = jFrame.getContentPane();
        contentPane.add(jPanel, BorderLayout.CENTER);
        jFrame.setResizable(false);
        jFrame.setVisible(true);

        // 初始化消息实例
        myId = userId;
        MessageDao msgDao = new MessageDao();
        listMessage = msgDao.getMyMessage(userId);

        // 初始化用户对象实例，为发送对象下拉列表框赋值
        UserDao userDao = new UserDao();
        List<UserBean> listUser = new ArrayList<UserBean>();
        listUser = userDao.getUserInfo();
        UserBean userBean = new UserBean();
        for (int i = 0; i < listUser.size(); i++) {
            userBean = listUser.get(i);
            jComboBoxReceiver.addItem(new Item(userBean.getUserId(), userBean.getUserName()));
        }

        // 发送对象选择单击事件
        jComboBoxReceiver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                item = (Item) jComboBoxReceiver.getSelectedItem();
            }
        });

        // 发送消息按钮单击事件
        jButtonSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 将发送的消息插入数据库
                try {
                    if (item == null) {
                        JOptionPane.showMessageDialog(null, "请选择消息发送对象！");
                    } else {
                        InetAddress iAddr = InetAddress.getLocalHost();
                        msgDao.addMessage(userId, iAddr.getHostAddress(), jTextMessage.getText(), item.getKey());
                        listMessage = msgDao.getMyMessage(userId);
                        getMsgTable().updateUI();
                    }
                } catch (UnknownHostException en) {
                    en.printStackTrace();
                }
            }
        });
    }

    // 显示列表，以下内容为表格的属性设置，可以不改动
    private JTable getMsgTable() {
        if (jTable == null) {
            jTable = new JTable();
            jTable.setModel(getDBViewModel());
            // 设置表是否绘制单元格周围的网格线
            jTable.setShowGrid(true);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTable.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTable.getColumnModel().getColumn(2).setPreferredWidth(300);
            jTable.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTable.getColumnModel().getColumn(4).setPreferredWidth(80);
            // 设置表头和行高
            jTable.getTableHeader().setPreferredSize(new Dimension(0, 30));
            jTable.setRowHeight(30);
            // 设置table内容居中
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jTable.setDefaultRenderer(Object.class, tcr);

            // 鼠标点击事件，在此修改已读和未读的标志位
            jTable.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    try {
                        if (jTable.getValueAt(jTable.getSelectedRow(), 0) != null) {
                            // 消息接收人是自己并且未读的情况下更改已读标志位
                            if (jTable.getValueAt(jTable.getSelectedRow(), 3).equals(myId)
                                    && jTable.getValueAt(jTable.getSelectedRow(), 4).equals(0)) {
                                // 获取所选中的行的第一个位置的内容，当然你也可以指定具体的该行第几格
                                Integer messageId = (Integer) jTable.getValueAt(jTable.getSelectedRow(), 0);
                                MessageDao msgDao = new MessageDao();
                                InetAddress iAddr = InetAddress.getLocalHost();
                                msgDao.updateMessage(iAddr.getHostAddress(), messageId);
                                listMessage = msgDao.getMyMessage(myId);
                                getMsgTable().updateUI();
                            }
                        }
                    } catch (UnknownHostException e1) {
                        e1.printStackTrace();
                    }
                }
            });
        }
        return jTable;
    }

    // 实例化列表格式
    private DBViewTableModel getDBViewModel() {
        if (dbViewModel == null) {
            dbViewModel = new DBViewTableModel();
        }
        return dbViewModel;
    }

    // 设置列表格式
    private class DBViewTableModel extends DefaultTableModel {
        private static final long serialVersionUID = 1L;

        // 设置单元格不可编辑
        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        // 返回表格的列数
        @Override
        public int getColumnCount() {
            return 5;
        }

        // 返回表格的行数
        @Override
        public int getRowCount() {
            return listMessage.size();
        }

        // 文件列表表头
        public String getColumnName(int col) {
            switch (col) {
                case 0:
                    return "序号";
                case 1:
                    return "发送人";
                case 2:
                    return "消息内容";
                case 3:
                    return "接收人";
                case 4:
                    return "状态";
            }
            return "";
        }

        // 显示列表值
        @Override
        public Object getValueAt(int row, int col) {
            msgBean = listMessage.get(row);
            if (col == 0) {
                return msgBean.getMessageId();
            }
            if (col == 1) {
                return msgBean.getSenderName();
            }
            if (col == 2) {
                return msgBean.getMessageContext();
            }
            if (col == 3) {
                return msgBean.getReceiveName();
            }
            if (col == 4) {
                if (msgBean.getMessageFlag().equals(0)) {
                    return "未读";
                } else {
                    return "已读";
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        new MsgDemo_03(0, "sss");
    }

}
