package com.nit.dbms.server.gui;

import com.nit.dbms.server.MsgClientThread_08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MsgClientUI_07 extends JFrame {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        MsgClientUI_07 client = new MsgClientUI_07();
    }

    public JButton btStart;
    public JButton btSend;
    public JTextField tfSend;
    public JTextField tfIP;
    public JTextField tfPort;

    public JTextArea taShow;
    public MsgClientThread_08 server;

    public MsgClientUI_07() {
        super("客户端");
        btStart = new JButton("启动连接");
        btSend = new JButton("发送信息");
        tfSend = new JTextField(10);
        taShow = new JTextArea();
        tfIP = new JTextField("127.0.0.1");
        tfPort = new JTextField("1228");

        btStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server = new MsgClientThread_08(MsgClientUI_07.this);
            }
        });
        btSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.sendMsg(tfSend.getText());
                tfSend.setText("");
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "确定关闭吗？", "温馨提示", JOptionPane.YES_NO_OPTION);
                if (a == 1) {
                    // 关闭
                    System.exit(0);
                }
            }
        });
        JPanel bottom = new JPanel(new FlowLayout());
        bottom.add(btStart);
        bottom.add(tfSend);
        bottom.add(btSend);
        this.add(bottom, BorderLayout.SOUTH);
        final JScrollPane sp = new JScrollPane();
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setViewportView(this.taShow);
        this.taShow.setEditable(false);
        this.add(sp, BorderLayout.CENTER);
        JPanel top = new JPanel(new FlowLayout());
        top.add(tfIP);
        top.add(tfPort);
        this.add(top, BorderLayout.NORTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置显示大小及位置等属性
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int SwingX = 500;
        int SwingY = 400;
        this.setBounds(screenSize.width / 2 - SwingX / 2, screenSize.height / 2 - SwingY / 2, SwingX, SwingY);
        this.setSize(SwingX, SwingY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
}
