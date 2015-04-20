package com.cocome.DAO;

import java.sql.SQLException;
import java.util.List;

/*
 * @Coded By Mrunal
	Do not make any changes
	Interface for friends. To fetch list of friends
*
*/

public interface FriendsChatDAO {

	List<String> getFriendsList(String user_name) throws SQLException; 
}
