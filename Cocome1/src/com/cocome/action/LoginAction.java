package com.cocome.action;

import java.sql.SQLException;
import java.util.Map;

import com.cocome.DAO.Login;
import com.cocome.DAO.LoginDAOImpl;
import com.cocome.DAO.UserDAOImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	
	String userId;
	String password;
	
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1976838670802225984L;
	//private User user;

	
	public String execute() throws ClassNotFoundException, SQLException{
//		String ret = ERROR;
//	    Connection conn = null;
//	    
//	    try {
//	         String URL = "jdbc:mysql://localhost:3306/testdb";
//	         Class.forName("com.mysql.jdbc.Driver");
//	         conn = DriverManager.getConnection(URL, "root", "root");
//	         String sql = "SELECT name FROM login WHERE";
//	         sql+=" user = ? AND password = ?";
//	         PreparedStatement ps = conn.prepareStatement(sql);
//	         ps.setString(1, user.getUserId());
//	         ps.setString(2, user.getPassword());
//	         ResultSet rs = ps.executeQuery();
//
//	         while (rs.next()) {
//	            user.setName(rs.getString(1));
//	            ret = SUCCESS;
//	         }
//	      } catch (Exception e) {
//	         ret = ERROR;
//	      } finally {
//	         if (conn != null) {
//	            try {
//	               conn.close();
//	            } catch (Exception e) {
//	            }
//	         }
//	      }
		Login login=new Login();
		login.setUser_id(getUserId());
		login.setPassword(getPassword());
		LoginDAOImpl loginDAO =new LoginDAOImpl();
		if(loginDAO.validateUser(login)){
			
			UserDAOImpl userDAO=new UserDAOImpl();
			Map session = ActionContext.getContext().getSession();
			session.put("user",userDAO.getUserDetails(getUserId()) );
			return SUCCESS;
		}
		return ERROR;
		
		
	      		
	}
	
//	public User getUser() {
//	      return user;
//	   }
//
//	public void setUser(User user) {
//	      this.user = user;
//	   }

	
}
