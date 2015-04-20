package com.cocome.action;

import java.sql.SQLException;
import java.util.Map;

import com.cocome.DAO.FriendsDAO;
import com.cocome.DAO.FriendsDAOImpl;
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
		UserDAOImpl userdao=new UserDAOImpl();
		user=userdao.getUserDetails(friend_id);
		System.out.println(user.getFirst_name());
		return SUCCESS;
	}
	
	public String SearchFriend() throws ClassNotFoundException, SQLException{
		User usermain;
		Map session = ActionContext.getContext().getSession();
		usermain=(User)session.get("user");
		FriendsDAO frnd_obj=new FriendsDAOImpl();
		UserDAOImpl userdao=new UserDAOImpl();
		user=userdao.getUserDetails(friend_id);
		if(frnd_obj.IfFriends(usermain.getUser_id(), friend_id)){
			return "friend";
		}
		else{
			return "stranger";
		}
	}
	
	public String UnFriend() throws ClassNotFoundException, SQLException{
        Map session = ActionContext.getContext().getSession();
        user=(User)session.get("user");
        FriendsDAO frnd_obj=new FriendsDAOImpl();
        if(frnd_obj.DelFriends(user.getUser_id(), friend_id)){
              return SUCCESS;
        }
        else
              return ERROR;
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
