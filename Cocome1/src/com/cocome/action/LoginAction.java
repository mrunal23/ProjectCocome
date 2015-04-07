package com.cocome.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cocome.bean.User;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1976838670802225984L;
	private User user;

	
	public String execute(){
		String ret = ERROR;
	    Connection conn = null;
	    
	    try {
	         String URL = "jdbc:mysql://localhost:3306/testdb";
	         Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(URL, "root", "root");
	         String sql = "SELECT name FROM login WHERE";
	         sql+=" user = ? AND password = ?";
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ps.setString(1, user.getUserId());
	         ps.setString(2, user.getPassword());
	         ResultSet rs = ps.executeQuery();

	         while (rs.next()) {
	            user.setName(rs.getString(1));
	            ret = SUCCESS;
	         }
	      } catch (Exception e) {
	         ret = ERROR;
	      } finally {
	         if (conn != null) {
	            try {
	               conn.close();
	            } catch (Exception e) {
	            }
	         }
	      }
	      return ret;		
	}
	
	public User getUser() {
	      return user;
	   }

	public void setUser(User user) {
	      this.user = user;
	   }

	
}
