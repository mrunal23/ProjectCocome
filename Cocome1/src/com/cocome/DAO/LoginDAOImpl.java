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
		if(res==1){
			//setting user object in session
					statement.close();
					return true;
			}
			
		
		
			return false;
	}
	
	@Override
	public boolean DeleteUser(String user_id) throws SQLException {
		
		String query="delete from login where user_id=?";
		statement= (PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, user_id);
		int res=statement.executeUpdate();
		
		if(res==1){
			//setting user object in session
					statement.close();
					return true;
			}
			
		
		
			return false;
	}
	
	@Override
	public boolean updateLogin(Login login) throws SQLException {
		String query="update login set password=? where user_id=?";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		System.out.println(login.getPassword());
		System.out.println(login.getUser_id());
		statement.setString(1, login.getPassword());
		statement.setString(2,login.getUser_id());
		int val=statement.executeUpdate();
		statement.close();
		if(val>0)
			return true;
		else
			return false;
	}
	
	
	@Override
	public Login getLoginDetails(String user_id) throws SQLException {
		Login login=null;
		String query="select * from  login where user_id=?";
		statement= (PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1,user_id);
		ResultSet result=statement.executeQuery();
		if(result.next()){
				login=new Login();
				login.setUser_id(user_id);
				login.setPassword(result.getString("password"));
		}
		statement.close();
		return login;
	}

}
