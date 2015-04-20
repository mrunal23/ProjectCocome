package com.cocome.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.cocome.DAO.FriendsChatDAOImpl;
import com.cocome.DAO.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


//@Coded By Mrunal
//Do not make any changes
//Action classes required for chatting
//Fetches list of friends

public class FetchFriendListAction extends ActionSupport{

	private List<String> friends_list;
	private String my_user_id;	
	
	public String getMy_user_id() {
		return my_user_id;
	}

	public void setMy_user_id(String my_user_id) {
		this.my_user_id = my_user_id;
	}

	public List<String> getFriends_list() {
		return friends_list;
	}

	public void setFriends_list(List<String> friends_list) {
		this.friends_list = friends_list;
	}

	//Fetch list of friends for a given user
	public String fetchFriendList() throws ClassNotFoundException, SQLException{
		Map session = ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		System.out.println("In fetch message of user");
		FriendsChatDAOImpl fr=new FriendsChatDAOImpl();
		setMy_user_id(user.getUser_id());
		System.out.println(my_user_id);
		friends_list=fr.getFriendsList(user.getUser_id());
		System.out.println("In Action class");
		for(String i:friends_list){
			System.out.println(i);
		}
		return SUCCESS;
		
	}
}
