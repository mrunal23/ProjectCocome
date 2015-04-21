package com.cocome.action;

import java.sql.SQLException;
import java.util.Map;

import com.cocome.DAO.FriendRequestsDAO;
import com.cocome.DAO.FriendRequestsDAOImpl;
import com.cocome.DAO.FriendsDAO;
import com.cocome.DAO.FriendsDAOImpl;
import com.cocome.DAO.User;
import com.cocome.DAO.UserDAOImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MyProfileAction extends ActionSupport {
	
	private User user;
	private String friend_id;
	private boolean pend_req;
	
	

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
		return SUCCESS;
	}
	
	public String DisplayPublicDetails() throws ClassNotFoundException, SQLException{
		UserDAOImpl userdao=new UserDAOImpl();
		User usermain;
		Map session = ActionContext.getContext().getSession();
		usermain=(User)session.get("user");
		user=userdao.getUserDetails(friend_id);
		FriendRequestsDAO frndreq_obj=new FriendRequestsDAOImpl();
		if(frndreq_obj.IsFriendReqPending(usermain.getUser_id(), friend_id) || frndreq_obj.IsFriendReqPending(friend_id,usermain.getUser_id()))
			setPend_req(true);
		else
			setPend_req(false);
		return SUCCESS;
	}
	
	public String SearchFriend() throws ClassNotFoundException, SQLException{
		User usermain;
		Map session = ActionContext.getContext().getSession();
		usermain=(User)session.get("user");
		FriendsDAO frnd_obj=new FriendsDAOImpl();
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
	
	public String AddFriend() throws ClassNotFoundException, SQLException{
        Map session = ActionContext.getContext().getSession();
        user=(User)session.get("user");
        FriendRequestsDAO frnd_obj=new FriendRequestsDAOImpl();
        if(frnd_obj.AddFriendRequests(user.getUser_id(), friend_id)){
        		System.out.println("Friend Added");
              return SUCCESS;
        }
        else
              return ERROR;
  }
	
	public boolean isPend_req() {
		return pend_req;
	}

	public void setPend_req(boolean pend_req) {
		this.pend_req = pend_req;
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
