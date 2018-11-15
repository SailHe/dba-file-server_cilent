package com.nit.demo.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.Socket;
import java.util.List;

/*这个类是消息服务器端的UI*/
public class MsgServerUI_04 extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		@SuppressWarnings("unused")
        MsgServerUI_04 serverUI = new MsgServerUI_04();
	}

    // 启动服务器
	public JButton btStart;
    // 信息展示
	public JTextArea taShow;
    // 用来监听客户端连接
	public MsgServerThread_05 server;
    // 保存连接到服务器的客户端
	static List<Socket> clients;

	public MsgServerUI_04() {
		super("服务器端");
		taShow = new JTextArea();
		btStart = new JButton("启动服务");

		//启动监听线程
		btStart.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
				server = new MsgServerThread_05(MsgServerUI_04.this);
			}
		});

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int a = JOptionPane.showConfirmDialog(null, "确定关闭吗？", "温馨提示", JOptionPane.YES_NO_OPTION);
				if (a == 1) {
					server.closeServer();
                    // 关闭
					System.exit(0);
				}
			}
		});
		JPanel top = new JPanel(new FlowLayout());
		top.add(btStart);
		this.add(top, BorderLayout.SOUTH);
		final JScrollPane sp = new JScrollPane();
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setViewportView(this.taShow);
		this.taShow.setEditable(false);
		this.add(sp, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置显示大小及位置等属性
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int SwingX = 400;
		int SwingY = 500;
		this.setBounds(screensize.width / 2 - SwingX / 2, screensize.height / 2 - SwingY / 2, SwingX, SwingY);
		this.setSize(SwingX, SwingY);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
}
