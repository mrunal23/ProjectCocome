package com.cocome.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class FriendsDAOImpl implements FriendsDAO {
	private Connection db_connection;
	private PreparedStatement statement;
	private String query;
	UserDAOImpl userDAO;
	public FriendsDAOImpl() throws ClassNotFoundException, SQLException{
		db_connection=DBConnection_Singleton.getInstance().getDBConnection();
	}

	@Override
	public List<Friends> getFriendsOfUser(String user_id) throws SQLException, ClassNotFoundException {
		List<Friends> friends=new ArrayList<Friends>();
		query="select friend_user_id from friends where user_id=?";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, user_id);
		ResultSet rs=statement.executeQuery();
		userDAO = new UserDAOImpl();
		while(rs.next()){
			Friends friend=new Friends();
			friend.setUser(userDAO.getUserDetails(rs.getString("friend_user_id")));
			
			friends.add(friend);
		}
		
		System.out.println("Friends Details");
		for(Friends fr:friends){
			System.out.println(fr.getUser().getFirst_name());
		}
		statement.close();
		return friends;		
	}
		
}
