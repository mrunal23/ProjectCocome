package com.cocome.DAO;

import java.sql.SQLException;
import java.util.List;

public interface PostsDAO {
	List<Posts> getPostsOfUser(String user_id) throws SQLException;
	boolean insertPosts(Posts posts) throws SQLException;
   
}
