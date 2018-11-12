package com.nit.dbms.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*这个类是服务器端的等待客户端发送信息*/
public class MsgServerListen_06 extends Thread {
	BufferedReader reader;
	PrintWriter writer;
	MsgServerUI_04 ui;
	Socket client;

	public MsgServerListen_06(MsgServerUI_04 ui, Socket client) {
		this.ui = ui;
		this.client = client;
		this.start();
	}

	// 为每一个客户端创建线程等待接收信息，然后把信息广播出去
	@Override
	public void run() {
		String msg = "";
		while (true) {
			try {
				reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
				writer = new PrintWriter(client.getOutputStream(), true);
				msg = reader.readLine();
				sendMsg(msg);
			} catch (IOException e) {
				println(e.toString());
				break;
			}
			if (msg != null && msg.trim() != "") {
				println(">>" + msg);
			}
		}
	}

	// 把信息发送到所有指定用户
	@SuppressWarnings("static-access")
	public synchronized void sendMsg(String msg) {
		try {
			for (int i = 0; i < ui.clients.size(); i++) {
				Socket client = ui.clients.get(i);
				writer = new PrintWriter(client.getOutputStream(), true);
				writer.println(msg);
			}
		} catch (Exception e) {
			println(e.toString());
		}
	}

	public void println(String s) {
		if (s != null) {
			this.ui.taShow.setText(this.ui.taShow.getText() + s + "\n");
			System.out.println(s + "\n");
		}
	}
}
