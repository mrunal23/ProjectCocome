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

public class TimelineDAOImpl implements TimelineDAO {
	private Connection db_connection;
	private PreparedStatement statement1;
	
	private String query1;
	private String query2;
	private String query3;
	private String query4;
	private String query5;
	private String query6;
	
	
	public TimelineDAOImpl() throws ClassNotFoundException, SQLException{
		db_connection=DBConnection_Singleton.getInstance().getDBConnection();
	}
	
	
	@Override
	public List<Timeline> getTimelineOfUser(String user_id) throws SQLException, ClassNotFoundException {
		List<Timeline> timelines=new ArrayList<Timeline>();
		Map session = ActionContext.getContext().getSession();
		User user=(User) session.get("user");
		
//		// Getting posts of user
//		query1="select * from posts where user_id=?";
//		statement1=(PreparedStatement) db_connection.prepareStatement(query1);
//		statement1.setString(1, user_id);		
//		ResultSet rs=statement1.executeQuery();
//		while(rs.next()){
//			Timeline timeline=new Timeline();
//			timeline.setType_of_feed("My Status Message");
//			timeline.setComment("");
//			timeline.setContent(rs.getString("content"));			
//			timeline.setDate(new Timestamp(rs.getDate("post_date").getTime()));
//			timeline.setLikes(Integer.toString(rs.getInt("likes_count")) + " Likes");			
//			timeline.setDislikes(Integer.toString(rs.getInt("dislike_count")) + " Dis-likes");
//			timelines.add(timeline);
//		}
		
//		
//		for (Timeline ts: timelines){
//			System.out.println(ts.getType_of_feed());
//			System.out.println(ts.getContent());
//			System.out.println(ts.getComment());
//			System.out.println(ts.getLikes());
//			System.out.println(ts.getDislikes());
//			System.out.println(ts.getDate());
//		}
//		
//		
		
		// Getting Questions of user
		query2="select * from questions where user_id=?";
		statement1=(PreparedStatement) db_connection.prepareStatement(query2);
		statement1.setString(1, user_id);		
		ResultSet rs1=statement1.executeQuery();
		while(rs1.next()){
			Timeline timeline=new Timeline();
			timeline.setType_of_feed("Question, I asked");			
			timeline.setContent(rs1.getString("content"));	
			
			timeline.setDate(new Timestamp(rs1.getDate("post_date").getTime()));
			timeline.setLikes(Integer.toString(rs1.getInt("upvote_count")) + " Up-Votes");			
			timeline.setDislikes(Integer.toString(rs1.getInt("downvote_count")) + " Down-Votes");
			timeline.setComment(Integer.toString(rs1.getInt("no_of_answers")) + " Answers Provided");
			timelines.add(timeline);
		}
		
		// Getting answers of users
		query3="select * from answers where user_id=?";
		statement1=(PreparedStatement) db_connection.prepareStatement(query3);
		statement1.setString(1, user_id);		
		ResultSet rs2=statement1.executeQuery();
		while(rs2.next()){
			Timeline timeline=new Timeline();
			timeline.setType_of_feed("Answers I Gave");
			
			//Get Question from Questions Table
			query5="select * from questions where qno=?";
			statement1=(PreparedStatement) db_connection.prepareStatement(query5);
			statement1.setInt(1, rs2.getInt("qid"));		
			ResultSet rs4=statement1.executeQuery();
			if (rs4.next()){
				timeline.setComment("Question: " + rs4.getString("content"));						
			}
			
			//timeline.setComment(Integer.toString(rs2.getInt("qid")) + " Number Answered");
			timeline.setContent(rs2.getString("content"));			
			timeline.setDate(new Timestamp(rs2.getTimestamp("post_date").getTime()));
			timeline.setLikes(Integer.toString(rs2.getInt("upvote_count")) + " Up-Votes");			
			timeline.setDislikes(Integer.toString(rs2.getInt("downvote_count")) + " Down-Votes");
			timelines.add(timeline);
		}
		
		// Getting friends of users
				query4="select * from friends where user_id=?";
				statement1=(PreparedStatement) db_connection.prepareStatement(query4);
				statement1.setString(1, user_id);		
				ResultSet rs3=statement1.executeQuery();
				while(rs3.next()){
					Timeline timeline=new Timeline();
					timeline.setType_of_feed("New Friend Added");
					
					//Get friend name from User Table
					query6="select * from user where user_id=?";
					statement1=(PreparedStatement) db_connection.prepareStatement(query6);
					statement1.setString(1, rs3.getString("friend_user_id"));		
					ResultSet rs5=statement1.executeQuery();
					if (rs5.next()){
						timeline.setContent("You became friends with " + rs5.getString("first_name") + " " + rs5.getString("last_name"));						
					}
					
					
					//timeline.setContent("You became friends with " + rs3.getString("friend_user_id"));
					timeline.setComment("Kudos to your friendship");			
					timeline.setDate(new Timestamp(rs3.getTimestamp("time").getTime()));
					timeline.setLikes("Memories");			
					timeline.setDislikes("Forever");
					timelines.add(timeline);
				}
			
		
		//Getting like-dislike activity on questions
		List<LikeDislikeRecord> likeDislikeRecords = new ArrayList<LikeDislikeRecord>();
		LikeDislikeRecordDAOImpl likeDislikeRecordDAO = new LikeDislikeRecordDAOImpl();
		
		likeDislikeRecords.addAll(likeDislikeRecordDAO.getLikeDisLikeQuestionsOfUser(user_id));
		
		
		//Getting like-dislike activity on answers
		
		likeDislikeRecords.addAll(likeDislikeRecordDAO.getLikeDisLikeAnswerssOfUser(user_id));
			
		//Getting like-dislike activity on posts
				
		likeDislikeRecords.addAll(likeDislikeRecordDAO.getLikeDisLikePostsOfUser(user_id));	
		
		for(LikeDislikeRecord eachLikeDisLikeRecord: likeDislikeRecords){
			Timeline timeline=new Timeline();
			if (eachLikeDisLikeRecord.isLike()){
				timeline.setType_of_feed("You Liked");
			}
			else{
				timeline.setType_of_feed("You Dis-liked");
			}
			if (eachLikeDisLikeRecord.getEntity_type() == 0){
				//Question
				QuestionsDAOImpl questionDAO = new QuestionsDAOImpl();
				Questions question = new Questions();
				question = questionDAO.getQuestion(eachLikeDisLikeRecord.getEntity_id());
				timeline.setContent("Question: " + question.getContent());
				timeline.setComment("Topic: " + question.getTopic() + "  |  " + " Posted By: " + question.getUser_id());
				timeline.setLikes(Integer.toString(question.getUpvote()) + " Up-Votes");
				timeline.setDislikes(Integer.toString(question.getDownvote()) + " Down-Votes");
			}
			else if (eachLikeDisLikeRecord.getEntity_type() == 1){
				//Answer
				AnswersDAOImpl answersDAO = new AnswersDAOImpl();
				Answers answer = new Answers();
				answer = answersDAO.getAnswer(eachLikeDisLikeRecord.getEntity_id());
				timeline.setContent("Answer: " + answer.getContent());
				QuestionsDAOImpl questionDAO = new QuestionsDAOImpl();
				Questions question = new Questions();
				question = questionDAO.getQuestion(answer.getQuestion_No());
				timeline.setComment("Question: " + question.getContent());
				timeline.setLikes(Integer.toString(answer.getUpvote()) + " Up-Votes");
				timeline.setDislikes(Integer.toString(answer.getUpvote()) + " Up-Votes");
			}
			else{
				//Posts
				PostsDAOImpl postsDAO = new PostsDAOImpl();
				Posts post = new Posts();
				post = postsDAO.getPost(eachLikeDisLikeRecord.getEntity_id());
				timeline.setContent("Status Update: ");
				timeline.setComment(post.getContent());
				timeline.setLikes(Integer.toString(post.getLikes_count()) + " Likes");
				timeline.setDislikes(Integer.toString(post.getDislikes_count()) + " Dis-likes");
			}
			
			timeline.setDate(eachLikeDisLikeRecord.getTimestamp());
			timelines.add(timeline);
			
		}
		
		statement1.close();
		//statement2.close();
		
		
		
		Collections.sort(timelines, new Comparator<Timeline>() {
			  public int compare(Timeline t1,  Timeline t2) {
			      if (t1.getDate() == null || t2.getDate() == null)
			        return 0;
			      return t2.getDate().compareTo(t1.getDate());
			  }
			});
		
		System.out.println("printing collected timeline info");
		for (Timeline ts: timelines){
			System.out.println(ts.getType_of_feed());
			System.out.println(ts.getContent());
			System.out.println(ts.getComment());
			System.out.println(ts.getLikes());
			System.out.println(ts.getDislikes());
			System.out.println(ts.getDate());
		}
		
		return timelines;		
	}


		
}
