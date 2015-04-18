package com.cocome.action;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.cocome.DAO.Login;
import com.cocome.DAO.LoginDAOImpl;
import com.cocome.DAO.User;
import com.cocome.DAO.UserDAOImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	
	private User user;
	private Login login;
	private String day;
	private String month;
	private String year;
	private String errMessage;
	private String name;
	
	
	public String execute() throws ClassNotFoundException, SQLException, ParseException{
		
		LoginDAOImpl loginDAO =new LoginDAOImpl();
		if(!loginDAO.validateNewUserEmail(login)){
			if(loginDAO.InsertUser(login)){
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
				String dateInString = getYear()+"-"+getMonth()+"-"+getDay();
				Date util_date=formatter.parse(dateInString);
				formatter = new SimpleDateFormat("yyyy-MM-dd");
				user.setUser_id(login.getUser_id());
				user.setDate_of_birth(java.sql.Date.valueOf(formatter.format(util_date)));
				UserDAOImpl new_user_updt=new UserDAOImpl();
				if(new_user_updt.insertUser(user)){
					setName(user.getFirst_name());
					Map session = ActionContext.getContext().getSession();
					session.put("user",new_user_updt.getUserDetails(login.getUser_id()) );
					//System.out.println("Register complete");
					return SUCCESS;
				}
					
			}
		}
		else{
			setErrMessage("Email id already exists");
		}
		
		
		return ERROR;
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


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getErrMessage() {
		return errMessage;
	}


	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	

}
