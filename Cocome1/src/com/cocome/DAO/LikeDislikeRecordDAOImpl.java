package com.cocome.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

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
	}

