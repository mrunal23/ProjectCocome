package com.cocome.action;

import java.sql.SQLException;
import java.util.Map;

import com.cocome.DAO.Login;
import com.cocome.DAO.LoginDAO;
import com.cocome.DAO.LoginDAOImpl;
import com.cocome.DAO.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AccountSettingsAction  extends ActionSupport {
	
	private Login login;

	public String load() throws ClassNotFoundException, SQLException{
		Map session = ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		LoginDAO login_obj=new LoginDAOImpl();
		login=login_obj.getLoginDetails(user.getUser_id());
		return SUCCESS;
	}
	
	public String ResetPassword() throws ClassNotFoundException, SQLException{
		LoginDAO login_obj=new LoginDAOImpl();
		Map session = ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		login.setUser_id(user.getUser_id());
		if(login_obj.updateLogin(login))
			return SUCCESS;
		else
			return ERROR;
	}
	
	public String DeleteProfile() throws ClassNotFoundException, SQLException{
		LoginDAO login_obj=new LoginDAOImpl();
		Map session = ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		if(login_obj.DeleteUser(user.getUser_id())){
			session.remove("user");
			return SUCCESS;
		}
		else
			return ERROR;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
}
