package com.cocome.DAO;

import java.sql.SQLException;

/*
 * @Coded By Mrunal
	Do not make any changes
	Interface for user_chat_details.
*
*/

public interface User_ChatDAO {
	String fetchChatDetails(String user_1,String user_2) throws SQLException;
	void createChatEntry(String uid,String user1,String user2) throws SQLException;
}
