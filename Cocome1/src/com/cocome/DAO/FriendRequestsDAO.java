package com.cocome.DAO;

import java.sql.SQLException;
import java.util.List;

public interface FriendRequestsDAO {
	List<FriendRequests> getFriendRequestsForUser(String user_id) throws SQLException, ClassNotFoundException;
	
   
}
