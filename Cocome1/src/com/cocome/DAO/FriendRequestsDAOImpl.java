package com.cocome.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class FriendRequestsDAOImpl implements FriendRequestsDAO {
	private Connection db_connection;
	private PreparedStatement statement;
	private String query;
	UserDAOImpl userDAO;
	public FriendRequestsDAOImpl() throws ClassNotFoundException, SQLException{
		db_connection=DBConnection_Singleton.getInstance().getDBConnection();
	}

	@Override
	public List<FriendRequests> getFriendRequestsForUser(String user_id) throws SQLException, ClassNotFoundException {
		List<FriendRequests> friendRequests=new ArrayList<FriendRequests>();
		query="select request_from from friend_requests where request_to=? and approved=?";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, user_id);
		statement.setInt(2, 0);
		ResultSet rs=statement.executeQuery();
		
		// getting friends of given user id which have not yet been approved
		userDAO = new UserDAOImpl();
		while(rs.next()){
			FriendRequests friendRequest=new FriendRequests();
			friendRequest.setRequest_from_user(userDAO.getUserDetails(rs.getString("request_from")));			
			friendRequest.setApproved(0);
			friendRequest.setRequest_to(user_id);			
			friendRequests.add(friendRequest);
		}
		
		System.out.println("Friends Request Details");
		for(FriendRequests fr:friendRequests){
			System.out.println(fr.getRequest_from_user().getFirst_name());
		}
		statement.close();
		return friendRequests;
	}
		
}
