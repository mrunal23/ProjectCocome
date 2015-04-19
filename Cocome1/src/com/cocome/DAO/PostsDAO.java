package com.cocome.DAO;

import java.sql.SQLException;
import java.util.List;

public interface PostsDAO {
	List<Posts> getPostsOfUser(String user_id) throws SQLException;
	boolean insertPosts(String user_id,String content) throws SQLException;
   
}
