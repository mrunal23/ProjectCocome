package com.cocome.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Map;

import com.cocome.DAO.PostsDAOImpl;
import com.cocome.DAO.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateStatus extends ActionSupport {
	private InputStream inputStream;
	private String comment;
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String updateStatus() throws ClassNotFoundException, SQLException{
		Map session = ActionContext.getContext().getSession();
		User user=(User) session.get("user");
		PostsDAOImpl postsDAO=new PostsDAOImpl();
		boolean result=postsDAO.insertPosts(user.getUser_id(), comment);
		inputStream = new ByteArrayInputStream(String.valueOf(result).getBytes(StandardCharsets.UTF_8));
		return SUCCESS;	
	
	}
}
