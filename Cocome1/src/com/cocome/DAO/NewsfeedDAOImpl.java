package com.cocome.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class NewsfeedDAOImpl implements NewsfeedDAO {
	private Connection db_connection;
	private PreparedStatement statement1;
	private PreparedStatement statement2;
	private String query1;
	private String query2;
	public NewsfeedDAOImpl() throws ClassNotFoundException, SQLException{
		db_connection=DBConnection_Singleton.getInstance().getDBConnection();
	}
	
	
	@Override
	public List<Newsfeed> getNewsfeedOfUser(String user_id) throws SQLException {
		List<Newsfeed> newsfeeds=new ArrayList<Newsfeed>();
		Map session = ActionContext.getContext().getSession();
		User user=(User) session.get("user");
		
		query1="select friend_user_id from friends where user_id=?";
		statement1=(PreparedStatement) db_connection.prepareStatement(query1);
		statement1.setString(1, user_id);		
		ResultSet rs=statement1.executeQuery();
		List<String> friendList = new ArrayList<String>();
				
		while(rs.next()){
			String friendUserId;
			friendUserId = rs.getString("friend_user_id");
			friendList.add(friendUserId);
		}
		
		
		System.out.println("retrieved Friends");
		for(String eachFrnd:friendList){
			System.out.println(eachFrnd);
		}
		System.out.println("My Last login time was");
		System.out.println(user.getLogout_time());
		
		//Getting posts of my friend which are after my last logout time
		
		List<Posts> posts=new ArrayList<Posts>();
		
		//Getting post for each friend
		for(String eachFrnd:friendList){
			System.out.println(eachFrnd);
			query2="select * from posts where user_id=? and post_date>?";
			statement1=(PreparedStatement) db_connection.prepareStatement(query2);
			statement1.setString(1, eachFrnd);
			statement1.setTimestamp(2, user.getLogout_time());
			ResultSet rs1=statement1.executeQuery();
			while(rs1.next()){
				Posts post=new Posts();
				System.out.println("fetching post for " + eachFrnd + " :: " + rs1.getString("content"));
				post.setPost_id(rs1.getInt("post_id"));
				post.setUser_id(rs1.getString("user_id"));
				post.setContent(rs1.getString("content"));
				post.setPost_date(new Timestamp(rs1.getDate("post_date").getTime()));
				post.setLikes_count(rs1.getInt("likes_count"));				
				posts.add(post);
			}
			
			for(Posts ps:posts){
				Newsfeed newsfeed=new Newsfeed();
				newsfeed.setType_of_feed("Friend's Updates");
				newsfeed.setPosted_by(ps.getUser_id());
				newsfeed.setDate(ps.getPost_date());
				newsfeed.setContent(ps.getContent());
				newsfeed.setComment_count(0);
				newsfeed.setLikes_count(ps.getLikes_count());
				newsfeed.setDislikes_count(ps.getLikes_count());
				newsfeeds.add(newsfeed);
				
			}
		}	
		
		statement1.close();
		//statement2.close();
		
		Collections.sort(newsfeeds, new Comparator<Newsfeed>() {
			  public int compare(Newsfeed n1,  Newsfeed n2) {
			      if (n1.getDate() == null || n2.getDate() == null)
			        return 0;
			      return n2.getDate().compareTo(n1.getDate());
			  }
			});
		
		return newsfeeds;		
	}
	
	
	
	
		
}
