package com.cocome.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GenericDAOImpl {
	private List<String> publicUserIDs;
	private Connection db_connection;
	private PreparedStatement statement;
	private String query;
	public GenericDAOImpl() throws ClassNotFoundException, SQLException{
		db_connection=DBConnection_Singleton.getInstance().getDBConnection();
	}

	public List<String> getPublicUsers(String user_id) throws SQLException {
		List<String> publicUsers=new ArrayList<String>();
		query="select user_id from user where user_id not in (select friend_user_id from friends where friends.user_id=?) and user_id !=?";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, user_id);
		statement.setString(2, user_id);
		ResultSet result = statement.executeQuery();
		while(result.next()){
			publicUsers.add(result.getString("user_id"));
			
		}
		return publicUsers;
	}
}
