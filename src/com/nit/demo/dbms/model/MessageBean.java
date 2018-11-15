package com.nit.demo.dbms.model;

public class MessageBean {

	private Integer messageId;
	private Integer messageSender;
	private String senderName;
	private String sendIP;
	private String sendTime;
	private String messageContext;
	private Integer messageReceiver;
	private String receiveName;
	private String receiveIP;
	private String receiveTime;
	private Integer messageFlag;

	public MessageBean() {
		super();
	}

	public MessageBean(Integer messageId, Integer messageSender, String senderName, String sendIP, String sendTime,
			String messageContext, Integer messageReceiver, String receiveName, String receiveIP, String receiveTime,
			Integer messageFlag) {
		super();
		this.messageId = messageId;
		this.messageSender = messageSender;
		this.senderName = senderName;
		this.sendIP = sendIP;
		this.sendTime = sendTime;
		this.messageContext = messageContext;
		this.messageReceiver = messageReceiver;
		this.receiveName = receiveName;
		this.receiveIP = receiveIP;
		this.receiveTime = receiveTime;
		this.messageFlag = messageFlag;
	}

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public Integer getMessageSender() {
		return messageSender;
	}

	public void setMessageSender(Integer messageSender) {
		this.messageSender = messageSender;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSendIP() {
		return sendIP;
	}

	public void setSendIP(String sendIP) {
		this.sendIP = sendIP;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getMessageContext() {
		return messageContext;
	}

	public void setMessageContext(String messageContext) {
		this.messageContext = messageContext;
	}

	public Integer getMessageReceiver() {
		return messageReceiver;
	}

	public void setMessageReceiver(Integer messageReceiver) {
		this.messageReceiver = messageReceiver;
	}

	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public String getReceiveIP() {
		return receiveIP;
	}

	public void setReceiveIP(String receiveIP) {
		this.receiveIP = receiveIP;
	}

	public String getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}

	public Integer getMessageFlag() {
		return messageFlag;
	}

	public void setMessageFlag(Integer messageFlag) {
		this.messageFlag = messageFlag;
	}

}
