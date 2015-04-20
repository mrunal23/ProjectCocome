package com.cocome.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Map;

import com.cocome.DAO.FriendRequestsDAOImpl;
import com.cocome.DAO.User;
import com.cocome.DAO.UserDAOImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ApproveFriendRequest extends ActionSupport {
	private String requesterID;
	private InputStream inputStream;
	
	public String getRequesterID() {
		return requesterID;
	}

	public void setRequesterID(String requesterID) {
		this.requesterID = requesterID;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String approveFriendRequest() throws ClassNotFoundException, SQLException{
		
		Map session = ActionContext.getContext().getSession();
		User user=(User) session.get("user");
		FriendRequestsDAOImpl friendRequestsDAO=new FriendRequestsDAOImpl();
		friendRequestsDAO.deleteFriendRequests(requesterID, user.getUser_id());
		UserDAOImpl userDAO=new UserDAOImpl();
		user=userDAO.getUserDetails(user.getUser_id());
		session.put("user", user);
		inputStream = new ByteArrayInputStream(String.valueOf(user.getPending_friend_requests()).getBytes(StandardCharsets.UTF_8));
		return SUCCESS;
	}
}
