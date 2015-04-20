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

public class LikeDislikeRecordDAOImpl {
	private Connection db_connection;
	private PreparedStatement statement;
	private String query;
	
	public LikeDislikeRecordDAOImpl() throws ClassNotFoundException, SQLException{
		db_connection=DBConnection_Singleton.getInstance().getDBConnection();
	}
	public boolean insert(int entity_type,int entity_id,String user_id,boolean like,boolean dislike) throws SQLException{
		System.out.println("LikeDislikeRecord insert");
		query="insert into likedislikerecord(entity_type,entity_id,user_id,`like`,dislike) values(?,?,?,?,?)";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setInt(1,entity_type);
		statement.setInt(2,entity_id);
		statement.setString(3,user_id);
		statement.setBoolean(4, like);
		statement.setBoolean(5, dislike);
		int val=statement.executeUpdate();
		if (val>0)
			return true;
		else
			return false;
	}
	
	public boolean checkUserActivity(String user_id,int entity_type,int entity_id,String activity) throws SQLException{
		System.out.println("check user activity");
		String queryForLike="select * from likedislikerecord where user_id=? and entity_type=? and entity_id=? and `like`=?";
		String queryForDislike="select * from likedislikerecord where user_id=? and entity_type=? and entity_id=? and dislike=?";
		ResultSet res;
		if(activity.equals("upvote")){
			//System.out.println("BINGOOO");
			statement=(PreparedStatement) db_connection.prepareStatement(queryForLike);
			statement.setString(1,user_id);
			statement.setInt(2,entity_type);
			statement.setInt(3,entity_id);
			statement.setBoolean(4, true);
			res=statement.executeQuery();
			if(res.next())
				return true;
			else
				return false;
		}
		else if(activity.equals("downvote")){
			//System.out.println("DOWNNNNNNNNN");
			statement=(PreparedStatement) db_connection.prepareStatement(queryForDislike);
			statement.setString(1,user_id);
			statement.setInt(2,entity_type);
			statement.setInt(3,entity_id);
			statement.setBoolean(4, true);
			res=statement.executeQuery();
			if(res.next())
				return true;
			else
				return false;
		}
		else
			return false;
}
	public boolean deleteUserActivity(String user_id,int entity_type,int entity_id,String activity) throws SQLException{
		//System.out.println("delete user activity");
		String queryForLike="delete from likedislikerecord where user_id=? and entity_type=? and entity_id=? and `like`=?";
		String queryForDislike="delete from likedislikerecord where user_id=? and entity_type=? and entity_id=? and dislike=?";
		int val;
		if(activity.equals("upvote")){
			//System.out.println("BINGOOO");
			statement=(PreparedStatement) db_connection.prepareStatement(queryForLike);
			statement.setString(1,user_id);
			statement.setInt(2,entity_type);
			statement.setInt(3,entity_id);
			statement.setBoolean(4, true);
			val=statement.executeUpdate();
			if(val>0)
				return true;
			else
				return false;
		}
		else if(activity.equals("downvote")){
			//System.out.println("DOWNNNNNNNNN");
			statement=(PreparedStatement) db_connection.prepareStatement(queryForDislike);
			statement.setString(1,user_id);
			statement.setInt(2,entity_type);
			statement.setInt(3,entity_id);
			statement.setBoolean(4, true);
			val=statement.executeUpdate();
			if(val>0)
				return true;
			else
				return false;
		}
		else
			return false;
	
	}
	
	public List<LikeDislikeRecord> getLikeDisLikeQuestionsOfUser(String user_id) throws SQLException {
		List<LikeDislikeRecord> likeDislikeRecords = new ArrayList<LikeDislikeRecord>();
		query = "select * from likedislikerecord where user_id=? and entity_type=?";
		statement = (PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, user_id);
		statement.setInt(2, 0);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			LikeDislikeRecord likeDislikeRecord = new LikeDislikeRecord();
			likeDislikeRecord.setId(rs.getInt("id"));
			likeDislikeRecord.setUser_id(rs.getString("user_id"));
			likeDislikeRecord.setEntity_id(rs.getInt("entity_id"));
			likeDislikeRecord.setEntity_type(rs.getInt("entity_type"));
			likeDislikeRecord.setLike(rs.getBoolean("like"));
			likeDislikeRecord.setDislike(rs.getBoolean("dislike"));
			likeDislikeRecord.setTimestamp(new Timestamp(rs.getDate("timestamp").getTime()));			
			likeDislikeRecords.add(likeDislikeRecord);
		}
		statement.close();

		return likeDislikeRecords;
	}
	
	public List<LikeDislikeRecord> getLikeDisLikeQuestionsOfUserAfterTime(String user_id, Timestamp post_date) throws SQLException {
		List<LikeDislikeRecord> likeDislikeRecords = new ArrayList<LikeDislikeRecord>();
		query = "select * from likedislikerecord where user_id=? and entity_type=? and timestamp=?";
		statement = (PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, user_id);
		statement.setInt(2, 0);
		statement.setTimestamp(3, post_date);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			LikeDislikeRecord likeDislikeRecord = new LikeDislikeRecord();
			likeDislikeRecord.setId(rs.getInt("id"));
			likeDislikeRecord.setUser_id(rs.getString("user_id"));
			likeDislikeRecord.setEntity_id(rs.getInt("entity_id"));
			likeDislikeRecord.setEntity_type(rs.getInt("entity_type"));
			likeDislikeRecord.setLike(rs.getBoolean("like"));
			likeDislikeRecord.setDislike(rs.getBoolean("dislike"));
			likeDislikeRecord.setTimestamp(new Timestamp(rs.getDate("timestamp").getTime()));			
			likeDislikeRecords.add(likeDislikeRecord);
		}
		statement.close();

		return likeDislikeRecords;
	}
	
	public List<LikeDislikeRecord> getLikeDisLikeAnswerssOfUser(String user_id) throws SQLException {
		List<LikeDislikeRecord> likeDislikeRecords = new ArrayList<LikeDislikeRecord>();
		query = "select * from likedislikerecord where user_id=? and entity_type=?";
		statement = (PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, user_id);
		statement.setInt(2, 1);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			LikeDislikeRecord likeDislikeRecord = new LikeDislikeRecord();
			likeDislikeRecord.setId(rs.getInt("id"));
			likeDislikeRecord.setUser_id(rs.getString("user_id"));
			likeDislikeRecord.setEntity_id(rs.getInt("entity_id"));
			likeDislikeRecord.setEntity_type(rs.getInt("entity_type"));
			likeDislikeRecord.setLike(rs.getBoolean("like"));
			likeDislikeRecord.setDislike(rs.getBoolean("dislike"));
			likeDislikeRecord.setTimestamp(new Timestamp(rs.getDate("timestamp").getTime()));			
			likeDislikeRecords.add(likeDislikeRecord);
		}
		statement.close();

		return likeDislikeRecords;
	}
	
	public List<LikeDislikeRecord> getLikeDisLikeAnswersOfUserAfterTime(String user_id, Timestamp post_date) throws SQLException {
		List<LikeDislikeRecord> likeDislikeRecords = new ArrayList<LikeDislikeRecord>();
		query = "select * from likedislikerecord where user_id=? and entity_type=? and timestamp=?";
		statement = (PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, user_id);
		statement.setInt(2, 1);
		statement.setTimestamp(3, post_date);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			LikeDislikeRecord likeDislikeRecord = new LikeDislikeRecord();
			likeDislikeRecord.setId(rs.getInt("id"));
			likeDislikeRecord.setUser_id(rs.getString("user_id"));
			likeDislikeRecord.setEntity_id(rs.getInt("entity_id"));
			likeDislikeRecord.setEntity_type(rs.getInt("entity_type"));
			likeDislikeRecord.setLike(rs.getBoolean("like"));
			likeDislikeRecord.setDislike(rs.getBoolean("dislike"));
			likeDislikeRecord.setTimestamp(new Timestamp(rs.getDate("timestamp").getTime()));			
			likeDislikeRecords.add(likeDislikeRecord);
		}
		statement.close();

		return likeDislikeRecords;
	}
	
	public List<LikeDislikeRecord> getLikeDisLikePostsOfUser(String user_id) throws SQLException {
		List<LikeDislikeRecord> likeDislikeRecords = new ArrayList<LikeDislikeRecord>();
		query = "select * from likedislikerecord where user_id=? and entity_type=?";
		statement = (PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, user_id);
		statement.setInt(2, 2);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			LikeDislikeRecord likeDislikeRecord = new LikeDislikeRecord();
			likeDislikeRecord.setId(rs.getInt("id"));
			likeDislikeRecord.setUser_id(rs.getString("user_id"));
			likeDislikeRecord.setEntity_id(rs.getInt("entity_id"));
			likeDislikeRecord.setEntity_type(rs.getInt("entity_type"));
			likeDislikeRecord.setLike(rs.getBoolean("like"));
			likeDislikeRecord.setDislike(rs.getBoolean("dislike"));
			likeDislikeRecord.setTimestamp(new Timestamp(rs.getDate("timestamp").getTime()));			
			likeDislikeRecords.add(likeDislikeRecord);
		}
		statement.close();

		return likeDislikeRecords;
	}
	
	public List<LikeDislikeRecord> getLikeDisLikePostsOfUserAfterTime(String user_id, Timestamp post_date) throws SQLException {
		List<LikeDislikeRecord> likeDislikeRecords = new ArrayList<LikeDislikeRecord>();
		query = "select * from likedislikerecord where user_id=? and entity_type=? and timestamp=?";
		statement = (PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, user_id);
		statement.setInt(2, 2);
		statement.setTimestamp(3, post_date);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			LikeDislikeRecord likeDislikeRecord = new LikeDislikeRecord();
			likeDislikeRecord.setId(rs.getInt("id"));
			likeDislikeRecord.setUser_id(rs.getString("user_id"));
			likeDislikeRecord.setEntity_id(rs.getInt("entity_id"));
			likeDislikeRecord.setEntity_type(rs.getInt("entity_type"));
			likeDislikeRecord.setLike(rs.getBoolean("like"));
			likeDislikeRecord.setDislike(rs.getBoolean("dislike"));
			likeDislikeRecord.setTimestamp(new Timestamp(rs.getDate("timestamp").getTime()));			
			likeDislikeRecords.add(likeDislikeRecord);
		}
		statement.close();

		return likeDislikeRecords;
	}
	

	public List<LikeDislikeRecord> getLikeDisLikeQuestionsOfUserFriendsAfterTime(String user_id, Timestamp post_date) throws SQLException {

		List<LikeDislikeRecord> likeDislikeRecords = new ArrayList<LikeDislikeRecord>();
		query = "select friend_user_id from friends where user_id=?";
		statement = (PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, user_id);
		ResultSet rs = statement.executeQuery();
		List<String> friendList = new ArrayList<String>();

		while (rs.next()) {
			String friendUserId;
			friendUserId = rs.getString("friend_user_id");
			friendList.add(friendUserId);
		}

		for (String eachFrnd : friendList) {

			List<LikeDislikeRecord> eachLikeDislikeRecordByFriend = new ArrayList<LikeDislikeRecord>();
			eachLikeDislikeRecordByFriend = getLikeDisLikeQuestionsOfUserAfterTime(eachFrnd, post_date);
			for (LikeDislikeRecord eachRecord : eachLikeDislikeRecordByFriend) {
				likeDislikeRecords.add(eachRecord);
			}
		}

		statement.close();		

		return likeDislikeRecords;
	}
	
	public List<LikeDislikeRecord> getLikeDisLikeAnswersOfUserFriendsAfterTime(String user_id, Timestamp post_date) throws SQLException {

		List<LikeDislikeRecord> likeDislikeRecords = new ArrayList<LikeDislikeRecord>();
		query = "select friend_user_id from friends where user_id=?";
		statement = (PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, user_id);
		ResultSet rs = statement.executeQuery();
		List<String> friendList = new ArrayList<String>();

		while (rs.next()) {
			String friendUserId;
			friendUserId = rs.getString("friend_user_id");
			friendList.add(friendUserId);
		}

		for (String eachFrnd : friendList) {

			List<LikeDislikeRecord> eachLikeDislikeRecordByFriend = new ArrayList<LikeDislikeRecord>();
			eachLikeDislikeRecordByFriend = getLikeDisLikeAnswersOfUserAfterTime(eachFrnd, post_date);
			for (LikeDislikeRecord eachRecord : eachLikeDislikeRecordByFriend) {
				likeDislikeRecords.add(eachRecord);
			}
		}

		statement.close();		

		return likeDislikeRecords;
	}
	
	public List<LikeDislikeRecord> getLikeDisLikePostsOfUserFriendsAfterTime(String user_id, Timestamp post_date) throws SQLException {

		List<LikeDislikeRecord> likeDislikeRecords = new ArrayList<LikeDislikeRecord>();
		query = "select friend_user_id from friends where user_id=?";
		statement = (PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, user_id);
		ResultSet rs = statement.executeQuery();
		List<String> friendList = new ArrayList<String>();

		while (rs.next()) {
			String friendUserId;
			friendUserId = rs.getString("friend_user_id");
			friendList.add(friendUserId);
		}

		for (String eachFrnd : friendList) {

			List<LikeDislikeRecord> eachLikeDislikeRecordByFriend = new ArrayList<LikeDislikeRecord>();
			eachLikeDislikeRecordByFriend = getLikeDisLikePostsOfUserAfterTime(eachFrnd, post_date);
			for (LikeDislikeRecord eachRecord : eachLikeDislikeRecordByFriend) {
				likeDislikeRecords.add(eachRecord);
			}
		}

		statement.close();		

		return likeDislikeRecords;
	}

	
	
	}

