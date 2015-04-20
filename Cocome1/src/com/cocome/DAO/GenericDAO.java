package com.cocome.DAO;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO {
	public List<String> getPublicUsers(String user_id) throws SQLException;
	
}
