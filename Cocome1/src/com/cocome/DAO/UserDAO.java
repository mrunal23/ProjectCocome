package com.cocome.DAO;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
	User getUserDetails(String user_id) throws SQLException;
	boolean insertUser(User user) throws SQLException;
    boolean updateUser(User user) throws SQLException;
    boolean deleteUser( String user_id) throws SQLException;
    String getFirstLastNameOfUser(String user_id) throws SQLException;
	List<User> getAllUsersByFirstName(String firstName) throws SQLException;
	boolean updateSignout(User user) throws SQLException;
    boolean updateLoginStatus(User user) throws SQLException;
}
