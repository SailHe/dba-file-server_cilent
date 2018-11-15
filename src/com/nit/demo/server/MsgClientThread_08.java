package com.nit.demo.server;

import com.nit.demo.server.gui.MsgClientUI_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MsgClientThread_08 extends Thread {
    MsgClientUI_07 ui;
    Socket client;
    BufferedReader reader;
    PrintWriter writer;

    public MsgClientThread_08(MsgClientUI_07 ui) {
        this.ui = ui;
        try {
            // 这里设置连接服务器端的IP的端口
            client = new Socket(ui.tfIP.getText(), Integer.parseInt(ui.tfPort.getText()));
            println("连接服务器[" + ui.tfIP.getText() + "]成功：端口[" + ui.tfPort.getText() + "]");
            reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            writer = new PrintWriter(client.getOutputStream(), true);
            // 如果为 true，则 println、printf 或 format 方法将刷新输出缓冲区
        } catch (IOException e) {
            println("连接服务器[" + ui.tfIP.getText() + "]成功：端口[" + ui.tfPort.getText() + "]");
            println(e.toString());
            e.printStackTrace();
        }
        this.start();
    }

    @Override
    public void run() {
        String msg = "";
        while (true) {
            try {
                msg = reader.readLine();
            } catch (IOException e) {
                println("服务器断开连接");
                break;
            }
            if (msg != null && msg.trim() != "") {
                println(">>" + msg);
            }
        }
    }

    public void sendMsg(String msg) {
        try {
            writer.println(msg);
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
