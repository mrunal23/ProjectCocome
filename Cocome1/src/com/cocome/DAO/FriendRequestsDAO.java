package com.cocome.DAO;

import java.sql.SQLException;
import java.util.List;

public interface FriendRequestsDAO {
	List<FriendRequests> getFriendRequestsForUser(String user_id) throws SQLException, ClassNotFoundException;
	boolean deleteFriendRequests(String requestFrom,String requestTo) throws SQLException, ClassNotFoundException;
	boolean IsFriendReqPending(String usermain,String friend) throws SQLException;
   
}
