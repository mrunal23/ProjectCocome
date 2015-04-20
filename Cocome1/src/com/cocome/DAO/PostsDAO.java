package com.cocome.DAO;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public interface PostsDAO {
	List<Posts> getPostsOfUser(String user_id) throws SQLException;
	boolean insertPosts(String user_id,String content) throws SQLException;
	List<Posts> getPostsOfUserAfterTime(String user_id, Timestamp post_date) throws SQLException;
	List<Posts> getPostsOfUsersFriends(String user_id, Timestamp post_date) throws SQLException;
	boolean updatePosts(Posts post) throws SQLException;
}
