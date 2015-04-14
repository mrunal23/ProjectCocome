package com.cocome.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class LoginDAOImpl implements LoginDAO {
	private Connection db_connection;
	public LoginDAOImpl() throws ClassNotFoundException, SQLException{
		db_connection=DBConnection_Singleton.getInstance().getDBConnection();
	}
	@Override
	public boolean validateUser(Login login) throws SQLException {
		
		String query="select * from login where user_id=? and password=?";
		PreparedStatement statement= (PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, login.getUser_id());
		statement.setString(2, login.getPassword());
		ResultSet res=statement.executeQuery();
		if(res.next()){
			//setting user object in session
			
					return true;
			}
			
		
		
			return false;
	}

}
