package com.cocome.action;

import java.sql.SQLException;
import java.util.Map;

import com.cocome.DAO.User;
import com.cocome.DAO.UserDAOImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MyProfileAction extends ActionSupport {
	
	private User user;
	private String friend_id;
	
	

	public String load(){
		System.out.println("My Profile Load enter");
		Map session = ActionContext.getContext().getSession();
		user=(User)session.get("user");
		System.out.println(user.getFirst_name());
		System.out.println("My Profile Load Exit");
		return SUCCESS;
	}
	
	public String DisplayDetails() throws ClassNotFoundException, SQLException{
		System.out.println("Friend Profile Load enter");
		UserDAOImpl userdao=new UserDAOImpl();
		user=userdao.getUserDetails(user.getUser_id());
		System.out.println(user.getFirst_name());
		System.out.println("Friend Profile Load Exit");
		return SUCCESS;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFriend_id() {
		return friend_id;
	}

	public void setFriend_id(String friend_id) {
		this.friend_id = friend_id;
	}

}
