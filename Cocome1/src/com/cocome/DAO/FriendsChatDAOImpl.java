package com.cocome.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/*
 * @Coded By Mrunal
	Do not make any changes
	Implementation for friends. To fetch list of friends
*
*/


public class FriendsChatDAOImpl implements FriendsChatDAO{

	private Connection db_connection;
	private PreparedStatement statement;
	private String query;
	
	public FriendsChatDAOImpl() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		db_connection=DBConnection_Singleton.getInstance().getDBConnection();
	}

	@Override
	public List<String> getFriendsList(String user_name) throws SQLException {
		// TODO Auto-generated method stub
		List<String> friends_list=new ArrayList<String>();
		query="select friend_user_id from friends where user_id=?";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, user_name);
		ResultSet rs=statement.executeQuery();
		System.out.println("In Friend_List Implementation");
		while(rs.next()){	
			System.out.println(rs.getString("friend_user_id"));
			friends_list.add(rs.getString("friend_user_id"));
		}
		statement.close();
		return friends_list;
	}	
}
