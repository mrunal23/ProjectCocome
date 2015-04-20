package com.cocome.DAO;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/*
 * @Coded By Mrunal
Do not make any changes
Interface for action class for messages
*
*/

public interface MessageDAO {
	List<MessageFetch> fetchMessages(String uid) throws SQLException;
	void addMessage(String uuid,String message,String currentTimeStamp) throws SQLException;
	List<MessageFetch> fetchMessagesWithTimestamp(String uid,int mess_id) throws SQLException;
}
