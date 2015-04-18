package com.cocome.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class LoginDAOImpl implements LoginDAO {
	private Connection db_connection;
	PreparedStatement statement;
	public LoginDAOImpl() throws ClassNotFoundException, SQLException{
		db_connection=DBConnection_Singleton.getInstance().getDBConnection();
	}
	@Override
	public boolean validateUser(Login login) throws SQLException {
		
		String query="select * from login where user_id=? and password=?";
		statement= (PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, login.getUser_id());
		statement.setString(2, login.getPassword());
		ResultSet res=statement.executeQuery();
		
		if(res.next()){
			//setting user object in session
			statement.close();
					return true;
			}
			
		
		
			return false;
	}
	
	@Override
	public boolean validateNewUserEmail(Login login) throws SQLException {
		
		String query="select * from login where user_id=?";
		statement= (PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, login.getUser_id());
		ResultSet res=statement.executeQuery();
		
		//System.out.println(res.);
		if(res.next()){
			statement.close();
			return true;
		}
			
		
		System.out.println("emailuser already exist");
			return false;
	}
	
	@Override
	public boolean InsertUser(Login login) throws SQLException {
		
		String query="insert into login(user_id,password) values(?,?)";
		statement= (PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, login.getUser_id());
		statement.setString(2, login.getPassword());
		int res=statement.executeUpdate();
		statement.close();
		if(res==1){
			//setting user object in session
			
					return true;
			}
			
		
		
			return false;
	}

}
