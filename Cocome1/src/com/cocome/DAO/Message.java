package com.cocome.DAO;

import java.sql.Timestamp;

/*
 * @Coded By Mrunal
	Do not make any changes
	Bean class for message
*
*/

public class Message {

	private int m_id;
	private String uuid;
	private String message;
	private Timestamp last_send;
	
	public Timestamp getLast_send() {
		return last_send;
	}
	public void setLast_send(Timestamp last_send) {
		this.last_send = last_send;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}	
	
}
