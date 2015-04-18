package com.cocome.DAO;

import java.sql.SQLException;
import java.util.List;

public interface FriendsDAO {
	List<Friends> getFriendsOfUser(String user_id) throws SQLException, ClassNotFoundException;
	
   
}
