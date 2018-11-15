package com.nit.demo.dbms.dao;

import com.nit.demo.dbms.model.MessageBean;
import com.nit.demo.dbms.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MessageDao {
	// 得到与我相关的消息表所有信息
	public List<MessageBean> getMyMessage(Integer userId) {
		Connection conn = null;
		PreparedStatement prestmt = null;
		ResultSet rs = null;
		List<MessageBean> listMessage = new ArrayList<MessageBean>();
		try {
			conn = DBUtil.getConn();
			// 通过预编译语句集的方式进行查询
			String sql = "select tbm.*, tbus.userName as SenderName, tbur.userName as ReceiveName from tb_message as tbm, tb_user as tbus, tb_user as tbur where tbm.messageSender = tbus.userId and tbm.messageReceiver = tbur.userId and (tbm.messageSender = ? or tbm.messageReceiver = ?) order by messageId desc";
			prestmt = conn.prepareStatement(sql);
			prestmt.setInt(1, userId);
			prestmt.setInt(2, userId);
			rs = prestmt.executeQuery();
			MessageBean msgBean = null;
			// 从数据集类型转化为List数据结构
			while (rs.next()) {
				msgBean = new MessageBean();
				msgBean.setMessageId(Integer.parseInt(rs.getString(1)));
				msgBean.setMessageSender(Integer.parseInt(rs.getString(2)));
				msgBean.setSendIP(rs.getString(3));
				msgBean.setSendTime(rs.getString(4));
				msgBean.setMessageContext(rs.getString(5));
				msgBean.setMessageReceiver(Integer.parseInt(rs.getString(6)));
				msgBean.setReceiveIP(rs.getString(7));
				msgBean.setReceiveTime(rs.getString(8));
				msgBean.setMessageFlag(Integer.parseInt(rs.getString(9)));
				msgBean.setSenderName(rs.getString(10));
				msgBean.setReceiveName(rs.getString(11));
				listMessage.add(msgBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库实例
			DBUtil.closeConn(rs, null, prestmt, null, conn);
		}
		return listMessage;
	}

	// 新增一条消息信息
	public int addMessage(Integer messageSender, String sendIP, String messageContext, Integer messageReceiver) {
		int result = 0;
		Connection conn = null;
		PreparedStatement prestmt = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			conn = DBUtil.getConn();
			String sql = "insert into tb_message(messageSender, sendIP, sendTime, messageContext, messageReceiver) values(?, ?, ?, ?, ?)";
			prestmt = conn.prepareStatement(sql);
			prestmt.setInt(1, messageSender);
			prestmt.setString(2, sendIP);
			prestmt.setString(3, sdf.format(new java.util.Date()));
			prestmt.setString(4, messageContext);
			prestmt.setInt(5, messageReceiver);
			result = prestmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库实例
			DBUtil.closeConn(null, null, prestmt, null, conn);
		}
		return result;
	}

	// 更新一条消息的状态位
	public int updateMessage(String ipAddress, Integer messageId) {
		int result = 0;
		Connection conn = null;
		PreparedStatement prestmt = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			conn = DBUtil.getConn();
			String sql = "update tb_message set receiveIP = ?, receiveTime = ?, messageFlag = ? where messageId = ?";
			prestmt = conn.prepareStatement(sql);
			prestmt.setString(1, ipAddress);
			prestmt.setString(2, sdf.format(new java.util.Date()));
			prestmt.setInt(3, 1);
			prestmt.setInt(4, messageId);
			result = prestmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库实例
			DBUtil.closeConn(null, null, prestmt, null, conn);
		}
		return result;
	}

}
