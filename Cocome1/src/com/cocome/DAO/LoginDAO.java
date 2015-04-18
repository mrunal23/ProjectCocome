package com.cocome.DAO;

import java.sql.SQLException;

public interface LoginDAO {
	boolean validateUser(Login login) throws SQLException;
	boolean InsertUser(Login login) throws SQLException;
	boolean validateNewUserEmail(Login login) throws SQLException;
	boolean updateLogin(Login login) throws SQLException;
}
