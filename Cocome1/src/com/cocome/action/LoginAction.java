package com.cocome.action;

import java.sql.SQLException;
import java.util.Map;
import com.cocome.DAO.Login;
import com.cocome.DAO.LoginDAOImpl;
import com.cocome.DAO.User;
import com.cocome.DAO.UserDAOImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	
	private Login login;
	private String name;
	
	public String execute() throws ClassNotFoundException, SQLException{


		LoginDAOImpl loginDAO =new LoginDAOImpl();
		if(loginDAO.validateUser(login)){
			
			UserDAOImpl userDAO=new UserDAOImpl();
			User user=userDAO.getUserDetails(login.getUser_id());
			setName(user.getFirst_name());
			Map session = ActionContext.getContext().getSession();
			session.put("user", user);
			return SUCCESS;
		}
		return ERROR;
		
		
	      		
	}
	
public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	
}
