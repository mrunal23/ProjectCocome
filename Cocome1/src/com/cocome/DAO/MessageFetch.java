package com.cocome.DAO;

import java.sql.Timestamp;

public class MessageFetch {
	private String message;
	private String last_send;
	private int m_id;
	
	
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public  String getLast_send() {
		return last_send;
	}
	public void setLast_send( String last_send) {
		this.last_send = last_send;
	}
	
	
}
