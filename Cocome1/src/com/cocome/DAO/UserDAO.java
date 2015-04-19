package com.cocome.DAO;

import java.sql.SQLException;

public interface UserDAO {
	User getUserDetails(String user_id) throws SQLException;
	boolean insertUser(User user) throws SQLException;
    boolean updateUser(User user) throws SQLException;
    boolean deleteUser( String user_id) throws SQLException;
    String getFirstLastNameOfUser(String user_id) throws SQLException;
}
