/**
 * @author bipra de
 * Date : 11-Apr-2015
 * This class is used to get single instance of the DBConnection_Singleton class. Implements Singleton pattern.
 */

package com.cocome.DAO;



import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBConnection_Singleton {
	private String myDriver = "org.gjt.mm.mysql.Driver";
	private String myUrl = "jdbc:mysql://localhost/Cocome";
	private Connection connection;
	private String username;
	private String password;
    private volatile static DBConnection_Singleton instance=null;
    
	private String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
    public String getMyDriver() {
		return myDriver;
	}
	public void setMyDriver(String myDriver) {
		this.myDriver = myDriver;
	}
	public String getMyUrl() {
		return myUrl;
	}
	public void setMyUrl(String myUrl) {
		this.myUrl = myUrl;
	}
	

	private DBConnection_Singleton() {
		if (!(instance == null)) {
			throw new RuntimeException(
					"Cannot create another connection to Database!!");
		}

	}
	//This method is used to get the instance of this class
	public static DBConnection_Singleton getInstance(){
		if(instance==null){
			synchronized(DBConnection_Singleton.class){
				if(instance==null){
					instance=new DBConnection_Singleton();
				}
			}
		}
		
		return instance;
	}
	
	//This method is used to get the connection to the MySQL database
	public Connection getDBConnection() throws SQLException, ClassNotFoundException{
		Class.forName(myDriver);
		if(connection==null)
			connection = (Connection) DriverManager. getConnection(myUrl,"root","root");
	    return connection;
	}

}
