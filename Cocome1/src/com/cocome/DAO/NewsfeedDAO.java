package com.cocome.DAO;

import java.sql.SQLException;
import java.util.List;

public interface NewsfeedDAO {
	List<Newsfeed> getNewsfeedOfUser(String user_id) throws SQLException;
	
   
}
