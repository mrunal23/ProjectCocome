package com.cocome.action;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import com.cocome.DAO.Login;
import com.cocome.DAO.LoginDAOImpl;
import com.cocome.DAO.UserDAOImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ForgotPasswordAction extends ActionSupport {
	
	private Login login;
	private String errMsg="";
	
	
	public String execute() throws ClassNotFoundException, SQLException, ParseException{
		
		LoginDAOImpl loginDAO =new LoginDAOImpl();
		if(loginDAO.validateNewUserEmail(login)){
			if(loginDAO.validateNewUserEmail(login)){
				
				String NewPwd=RandomString();
				login.setPassword(NewPwd);
				if(loginDAO.updateLogin(login)){
					EmailSendService obj=new EmailSendService();
					if(obj.SendMail(login))
						System.out.println("Mail Sent");
					setErrMsg("Your Password has been reset, please check your mail");
					return SUCCESS;
				}
			}
					
		}
		else{
			setErrMsg("Email id doesn't exist");
			//System.out.println(errMsg);
		}
				
		return ERROR;
	}
	
	public String load(){
		return SUCCESS;
	}
	
	
	private String RandomString(){
		   StringBuilder sb = new StringBuilder(12);
		   final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		   Random rnd = new Random();
		   for( int i = 0; i < 12; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		   return sb.toString();
		}
	
	
	
	
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	

}
