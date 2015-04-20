package com.cocome.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class PostsDAOImpl implements PostsDAO {
	private Connection db_connection;
	private PreparedStatement statement;
	private String query;
	private String query1;

	public PostsDAOImpl() throws ClassNotFoundException, SQLException {
		db_connection = DBConnection_Singleton.getInstance().getDBConnection();
	}

	public boolean insertPosts(String user_id, String content)
			throws SQLException {
		query = "insert into posts(user_id,content) values(?,?)";
		statement = (PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, user_id);
		statement.setString(2, content);
		int val = statement.executeUpdate();
		statement.close();
		if (val > 0)
			return true;
		else
			return false;
	}

	@Override
	public List<Posts> getPostsOfUser(String user_id) throws SQLException {
		List<Posts> posts = new ArrayList<Posts>();
		query = "select * from posts where user_id=?";
		statement = (PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, user_id);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			Posts post = new Posts();
			post.setPost_id(rs.getInt("post_id"));
			post.setUser_id(rs.getString("user_id"));
			post.setContent(rs.getString("content"));
			post.setPost_date(new Timestamp(rs.getDate("post_date").getTime()));
			post.setLikes_count(rs.getInt("likes_count"));
			post.setDislikes_count(rs.getInt("dislike_count"));
			posts.add(post);
		}
		statement.close();

		Collections.sort(posts, new Comparator<Posts>() {
			public int compare(Posts p1, Posts p2) {
				if (p1.getPost_date() == null || p2.getPost_date() == null)
					return 0;
				return p2.getPost_date().compareTo(p1.getPost_date());
			}
		});

		return posts;
	}

	public List<Posts> getPostsOfUserAfterTime(String user_id,
			Timestamp post_date) throws SQLException {
		List<Posts> posts = new ArrayList<Posts>();
		query = "select * from posts where user_id=? and post_date>?";
		statement = (PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, user_id);
		statement.setTimestamp(2, post_date);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			Posts post = new Posts();
			post.setPost_id(rs.getInt("post_id"));
			post.setUser_id(rs.getString("user_id"));
			post.setContent(rs.getString("content"));
			post.setPost_date(new Timestamp(rs.getDate("post_date").getTime()));
			post.setLikes_count(rs.getInt("likes_count"));
			post.setDislikes_count(rs.getInt("dislike_count"));
			posts.add(post);
		}
		statement.close();

		Collections.sort(posts, new Comparator<Posts>() {
			public int compare(Posts p1, Posts p2) {
				if (p1.getPost_date() == null || p2.getPost_date() == null)
					return 0;
				return p2.getPost_date().compareTo(p1.getPost_date());
			}
		});

		return posts;
	}

	public List<Posts> getPostsOfUsersFriends(String user_id,
			Timestamp post_date) throws SQLException {

		List<Posts> posts = new ArrayList<Posts>();

		query1 = "select friend_user_id from friends where user_id=?";
		statement = (PreparedStatement) db_connection.prepareStatement(query1);
		statement.setString(1, user_id);
		ResultSet rs = statement.executeQuery();
		List<String> friendList = new ArrayList<String>();

		while (rs.next()) {
			String friendUserId;
			friendUserId = rs.getString("friend_user_id");
			friendList.add(friendUserId);
		}

		for (String eachFrnd : friendList) {

			List<Posts> allPostByEachUser = new ArrayList<Posts>();
			allPostByEachUser = getPostsOfUserAfterTime(eachFrnd, post_date);
			for (Posts eachPost : allPostByEachUser) {
				posts.add(eachPost);
			}
		}

		statement.close();

		Collections.sort(posts, new Comparator<Posts>() {
			public int compare(Posts p1, Posts p2) {
				if (p1.getPost_date() == null || p2.getPost_date() == null)
					return 0;
				return p2.getPost_date().compareTo(p1.getPost_date());
			}
		});

		return posts;
	}

	public boolean updatePosts(Posts post) throws SQLException {
		query = "update posts set likes_count=?,dislike_count=? where post_id=?";
		statement = (PreparedStatement) db_connection.prepareStatement(query);
		statement.setInt(1, post.getLikes_count());
		statement.setInt(2, post.getDislikes_count());
		statement.setInt(3, post.getPost_id());
		int val = statement.executeUpdate();
		statement.close();
		if (val > 0)
			return true;
		else
			return false;
	}
	
	
	
	public Posts  getPost(int post_id) throws SQLException, ClassNotFoundException{
		//System.out.println("DAO "+question_no);
		query="select * from posts where post_id=?";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setInt(1, post_id);
		ResultSet rs=statement.executeQuery();
		
		if(rs.next()){
			Posts post=new Posts();
			post.setPost_id(post_id);
			post.setUser_id(rs.getString("user_id"));
			post.setContent(rs.getString("content"));
			
			post.setPost_date(rs.getTimestamp("post_date"));
			post.setLikes_count(rs.getInt("likes_count"));
			post.setDislikes_count(rs.getInt("dislike_count"));
			return post;
		}
		else
			return null;
		
	}
}
