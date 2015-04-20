package com.cocome.DAO;

import java.sql.SQLException;

public interface LikeDislikeRecordDAO {
public boolean insert(int entity_type,int entity_id,String user_id,boolean like,boolean dislike) throws SQLException;
public boolean deleteUserActivity(String user_id,int entity_type,int entity_id,String activity) throws SQLException;
}
