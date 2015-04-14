package com.cocome.DAO;

import java.sql.SQLException;

public interface LoginDAO {
	boolean validateUser(Login login) throws SQLException;
}
