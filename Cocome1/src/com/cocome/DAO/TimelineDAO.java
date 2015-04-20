package com.cocome.DAO;

import java.sql.SQLException;
import java.util.List;

public interface TimelineDAO {
	List<Timeline> getTimelineOfUser(String user_id) throws SQLException, ClassNotFoundException;
	
   
}
