package com.cocome.DAO;

import java.sql.SQLException;

public interface LoginDAO {
	boolean validateUser(Login login) throws SQLException;
	boolean InsertUser(Login login) throws SQLException;
	boolean validateNewUserEmail(Login login) throws SQLException;
	boolean updateLogin(Login login) throws SQLException;
	Login getLoginDetails(String user_id) throws SQLException;
	boolean DeleteUser(String user_id) throws SQLException;
}
