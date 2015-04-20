package com.cocome.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/*
 * @Coded By Mrunal
	Do not make any changes
	Implementation for User_chat details. To fetch chats with friends
*
*/

public class User_ChatDAOImpl implements User_ChatDAO{

	private Connection db_connection;
	private PreparedStatement statement;
	private String query;
	
	//constructor
	public User_ChatDAOImpl() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		db_connection=DBConnection_Singleton.getInstance().getDBConnection();
	}

	//to fetch previous chats of user.
	@Override
	public String fetchChatDetails(String user_1, String user_2) throws SQLException {
		// TODO Auto-generated method stub
		String user_uuid=null;
		System.out.println("in fetch chat details");
		query="select * from user_chat_details";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		ResultSet rs=statement.executeQuery();
		while(rs.next()){
			System.out.println("in db" + rs.getString("user_id1") + " and " + rs.getString("user_id2"));
			System.out.println("in function" + user_1 + " and " + user_2);
			if(rs.getString("user_id1").equalsIgnoreCase(user_1) && rs.getString("user_id2").equalsIgnoreCase(user_2)){
				//System.out.println(rs.getString("user_id1") + " and " + rs.getString("user_id2"));
				return rs.getString("uuid");
			}else if(rs.getString("user_id1").equalsIgnoreCase(user_2) && rs.getString("user_id2").equalsIgnoreCase(user_1)){
				return rs.getString("uuid");
			}
		}
		return null;
	}

	//to check if the pair of users have chatted before, if not then create a new entry for them in the db
	@Override
	public void createChatEntry(String uid, String user1, String user2)
			throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("in create chat entry function");
		//query="insert into questions(user_id,upvote_count,downvote_count,post_date,content,topic) values(?,?,?,?,?,?)";
		System.out.println("string uid is :: " + uid);
		System.out.println("string user1 is :: " + user1);
		System.out.println("string user2 is :: " + user2);
		System.out.println("in create chat entry function");
		query="insert into user_chat_details(uuid,user_id1,user_id2) values(?,?,?)";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, uid);
		statement.setString(2, user1);
		statement.setString(3, user2);
		int val=statement.executeUpdate();
		statement.close();		
	}

}
