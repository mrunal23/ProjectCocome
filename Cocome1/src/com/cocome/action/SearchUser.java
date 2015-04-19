package com.cocome.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cocome.DAO.User;
import com.cocome.DAO.UserDAOImpl;
import com.opensymphony.xwork2.ActionSupport;

public class SearchUser extends ActionSupport {
	private String searchInput;
	private List<User> searchResult;
	
	public String getSearchInput() {
		return searchInput;
	}

	public void setSearchInput(String searchInput) {
		this.searchInput = searchInput;
	}
	
	public List<User> getSearchResult() {
		return searchResult;
	}

	public void setSearchResult(List<User> searchResult) {
		this.searchResult = searchResult;
	}

	public String searchUser() throws ClassNotFoundException, SQLException {
		 
		UserDAOImpl userDAO=new UserDAOImpl();
		searchResult=userDAO.getAllUsersByFirstName(searchInput);
		return SUCCESS;
		
	}
}
