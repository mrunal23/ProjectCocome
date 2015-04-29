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
	
	private String query1;
	private String query2;
	private String query3;
	private String query4;
	private String query5;
	public NewsfeedDAOImpl() throws ClassNotFoundException, SQLException{
		db_connection=DBConnection_Singleton.getInstance().getDBConnection();
	}
	
	
	@Override
	public List<Newsfeed> getNewsfeedOfUser(String user_id) throws SQLException, ClassNotFoundException {
		List<Newsfeed> newsfeeds=new ArrayList<Newsfeed>();
		List<Posts> posts = new ArrayList<Posts>();
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
		
		
		
		
		for(String eachFrnd:friendList){
			System.out.println(eachFrnd);
			
			//Getting post for each friend
			PostsDAOImpl postsDAO = new PostsDAOImpl();
			List<Posts> allPostByEachUser = new ArrayList<Posts>();
			
//			allPostByEachUser = postsDAO.getPostsOfUserAfterTime(eachFrnd, user.getLogout_time());
//			for (Posts eachPost: allPostByEachUser){
//				posts.add(eachPost);
//			}
			
			//Continue coding after this
			
			
//			query2="select * from posts where user_id=? and post_date>?";
//			statement1=(PreparedStatement) db_connection.prepareStatement(query2);
//			statement1.setString(1, eachFrnd);
//			statement1.setTimestamp(2, user.getLogout_time());
//			ResultSet rs1=statement1.executeQuery();			
//			while(rs1.next()){
//				Newsfeed newsfeed=new Newsfeed();
//				newsfeed.setType_of_feed("Friend's Status Updates");
//				UserDAOImpl userDAO = new UserDAOImpl();			
//				newsfeed.setPosted_by(userDAO.getFirstLastNameOfUser(eachFrnd));				
//				newsfeed.setDate(new Timestamp(rs1.getDate("post_date").getTime()));
//				newsfeed.setContent(rs1.getString("content"));
//				newsfeed.setComment_count("");
//				newsfeed.setLikes_count(Integer.toString(rs1.getInt("likes_count")) + " Likes");
//				newsfeed.setDislikes_count(Integer.toString(rs1.getInt("dislike_count")) + " Dis-likes");
//				newsfeeds.add(newsfeed);
//			}
			
			//Getting Questions for each friend
			query3="select * from questions where user_id=? and post_date>?";
			statement1=(PreparedStatement) db_connection.prepareStatement(query3);
			statement1.setString(1, eachFrnd);
			statement1.setTimestamp(2, user.getLogout_time());
			ResultSet rs2=statement1.executeQuery();			
			while(rs2.next()){
				Newsfeed newsfeed=new Newsfeed();
				newsfeed.setType_of_feed("Question Posted");
				UserDAOImpl userDAO = new UserDAOImpl();			
				newsfeed.setPosted_by(userDAO.getFirstLastNameOfUser(eachFrnd));	
				newsfeed.setDate(new Timestamp(rs2.getTimestamp("post_date").getTime()));
				newsfeed.setContent(rs2.getString("content"));
				newsfeed.setComment_count(Integer.toString(rs2.getInt("no_of_answers")) + " Answers");
				newsfeed.setLikes_count(Integer.toString(rs2.getInt("upvote_count")) + " Up-votes");
				newsfeed.setDislikes_count(Integer.toString(rs2.getInt("downvote_count")) + " Down-votes");
				newsfeeds.add(newsfeed);
			}
			
			//Getting answers posted for questions one asked
			//query3="select * from questions where user_id=? and post_date>?";
		}	
		
		
		//getting Questions which were answered for my user
		QuestionsDAOImpl questionsDAO = new QuestionsDAOImpl();
		List<Questions> questions = new ArrayList<Questions>();
		questions = questionsDAO.getQuestionsOfUser(user_id);
		
		for(Questions eachQuestion:questions){
			query4="select * from answers where qid=? and post_date>?";
			statement1=(PreparedStatement) db_connection.prepareStatement(query4);
			statement1.setInt(1, eachQuestion.getQuestion_No());
			statement1.setTimestamp(2, user.getLogout_time());
			ResultSet rs3=statement1.executeQuery();			
			while(rs3.next()){
				Newsfeed newsfeed=new Newsfeed();
				newsfeed.setType_of_feed("Answers Posted");
				UserDAOImpl userDAO = new UserDAOImpl();			
				newsfeed.setPosted_by(userDAO.getFirstLastNameOfUser(rs3.getString("user_id")));	
				newsfeed.setDate(new Timestamp(rs3.getTimestamp("post_date").getTime()));
				newsfeed.setContent(rs3.getString("content"));
				newsfeed.setComment_count("Question: " + eachQuestion.getContent());
				newsfeed.setLikes_count(Integer.toString(rs3.getInt("upvote_count")) + " Up-votes");
				newsfeed.setDislikes_count(Integer.toString(rs3.getInt("downvote_count")) + " Down-votes");
				newsfeeds.add(newsfeed);
			}
		}
		
		//Getting Like Dislikes
		
		List<LikeDislikeRecord> likeDislikeRecords = new ArrayList<LikeDislikeRecord>();
		LikeDislikeRecordDAOImpl likeDislikeRecordDAO = new LikeDislikeRecordDAOImpl();
		
		likeDislikeRecords.addAll(likeDislikeRecordDAO.getLikeDisLikeQuestionsOfUserFriendsAfterTime(user_id, user.getLogout_time()));
		
		
		//Getting like-dislike activity on answers
		
		likeDislikeRecords.addAll(likeDislikeRecordDAO.getLikeDisLikeAnswersOfUserFriendsAfterTime(user_id, user.getLogout_time()));
			
		//Getting like-dislike activity on posts
				
		likeDislikeRecords.addAll(likeDislikeRecordDAO.getLikeDisLikePostsOfUserFriendsAfterTime(user_id, user.getLogout_time()));	
		
		for(LikeDislikeRecord eachLikeDisLikeRecord: likeDislikeRecords){
			Newsfeed newsfeed=new Newsfeed();
			if (eachLikeDisLikeRecord.isLike()){
				newsfeed.setType_of_feed("Your Friend Liked");
			}
			else{
				newsfeed.setType_of_feed("You Friend Dis-liked");
			}
			if (eachLikeDisLikeRecord.getEntity_type() == 0){
				//Question
				QuestionsDAOImpl questionDAO = new QuestionsDAOImpl();
				Questions question = new Questions();
				question = questionDAO.getQuestion(eachLikeDisLikeRecord.getEntity_id());
				newsfeed.setContent("Question: " + question.getContent());
				newsfeed.setComment_count("Topic: " + question.getTopic());
				newsfeed.setPosted_by(" Posted By: " + question.getUser_id());
				newsfeed.setLikes_count(Integer.toString(question.getUpvote()) + " Up-Votes");
				newsfeed.setDislikes_count(Integer.toString(question.getDownvote()) + " Down-Votes");
				
			}
			else if (eachLikeDisLikeRecord.getEntity_type() == 1){
				//Answer
				AnswersDAOImpl answersDAO = new AnswersDAOImpl();
				Answers answer = new Answers();
				answer = answersDAO.getAnswer(eachLikeDisLikeRecord.getEntity_id());				
				QuestionsDAOImpl questionDAO = new QuestionsDAOImpl();
				Questions question = new Questions();
				question = questionDAO.getQuestion(answer.getQuestion_No());		
				newsfeed.setContent("Answer: " + answer.getContent());
				newsfeed.setComment_count("Question: " + question.getContent());
				newsfeed.setPosted_by("Posted by: " + question.getUser_id());
				newsfeed.setLikes_count(Integer.toString(answer.getUpvote()) + " Up-Votes");
				newsfeed.setDislikes_count(Integer.toString(answer.getUpvote()) + " Down-Votes");
			}
			else{
				//Posts
				PostsDAOImpl postsDAO = new PostsDAOImpl();
				Posts post = new Posts();
				post = postsDAO.getPost(eachLikeDisLikeRecord.getEntity_id());
				newsfeed.setContent("Status Update: ");
				newsfeed.setComment_count(post.getContent());
				newsfeed.setPosted_by("-");
				newsfeed.setLikes_count(Integer.toString(post.getLikes_count()) + " Likes");
				newsfeed.setDislikes_count(Integer.toString(post.getDislikes_count()) + " Dis-likes");
				
			}
			
			newsfeed.setDate(eachLikeDisLikeRecord.getTimestamp());
			newsfeeds.add(newsfeed);
			
		}
		
		
		Collections.sort(newsfeeds, new Comparator<Newsfeed>() {
			  public int compare(Newsfeed n1,  Newsfeed n2) {
			      if (n1.getDate() == null || n2.getDate() == null)
			        return 0;
			      return n2.getDate().compareTo(n1.getDate());
			  }
			});
		statement1.close();
		return newsfeeds;		
	}


	
	
	
		
}
