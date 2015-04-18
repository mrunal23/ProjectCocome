package com.cocome.action;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Map;

import com.cocome.DAO.Login;
import com.cocome.DAO.LoginDAOImpl;
import com.cocome.DAO.User;
import com.cocome.DAO.UserDAOImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditProfileAction extends ActionSupport {
	
	User user;
	Login login;
	
	public String execute() throws ClassNotFoundException, SQLException{
			UserDAOImpl new_user_updt=new UserDAOImpl();
			if(new_user_updt.updateUser(user)){
				Map session = ActionContext.getContext().getSession();
				session.put("user",new_user_updt.getUserDetails(user.getUser_id()) );
				return SUCCESS;
			}
		
		return ERROR;
	}
	
	
	public String load() throws ClassNotFoundException, SQLException{
		System.out.println("Load enter");
		Map session = ActionContext.getContext().getSession();
		user=(User)session.get("user");
		System.out.println(user.getFirst_name());
		System.out.println("Load Exit");
		return SUCCESS;
}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Login getLogin() {
		return login;
	}


	public void setLogin(Login login) {
		this.login = login;
	}
	
	
	

}
