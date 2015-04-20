package com.cocome.action;

import java.sql.SQLException;
import java.util.Map;

import com.cocome.DAO.User;
import com.cocome.DAO.UserDAOImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SignOutAction extends ActionSupport {
	User user;
	
	public String execute() throws ClassNotFoundException, SQLException{
	    UserDAOImpl user_obj=new UserDAOImpl();
		Map session = ActionContext.getContext().getSession();
		user=(User)session.get("user");
		if(user_obj.updateSignout(user)){
			session.remove("user");
			return SUCCESS;
		}
		return ERROR;
	}

}
