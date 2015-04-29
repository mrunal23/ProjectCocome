package com.cocome.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class QuestionsDAOImpl implements QuestionsDAO {
	private Connection db_connection;
	private PreparedStatement statement;
	private String query;
	public QuestionsDAOImpl() throws ClassNotFoundException, SQLException{
		db_connection=DBConnection_Singleton.getInstance().getDBConnection();
	}
	public boolean insertQuestions(Questions questions) throws SQLException{
		query="insert into questions(user_id,upvote_count,downvote_count,post_date,content,topic,visibility) values(?,?,?,?,?,?,?)";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1,questions.getUser_id());
		statement.setInt(2, questions.getUpvote());
		statement.setInt(3, questions.getDownvote());
		statement.setTimestamp(4,questions.getTimestamp());
		statement.setString(5, questions.getContent());
		statement.setString(6, questions.getTopic());
		statement.setString(7, questions.getVisibility());
		int val=statement.executeUpdate();
		statement.close();
		if(val>0)
			return true;
		else
			return false;
	}
	
	@Override
	public List<Questions> getQuestionsOfUser(String user_id) throws SQLException, ClassNotFoundException {
		List<Questions> questions=new ArrayList<Questions>();
		query="select * from questions where user_id=?";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, user_id);
		ResultSet rs=statement.executeQuery();
		UserDAOImpl userDAO=new UserDAOImpl();
		while(rs.next()){
			Questions question=new Questions();
			question.setQuestion_No(rs.getInt("qno"));
			question.setUser(userDAO.getUserDetails(rs.getString("user_id")));
			question.setUpvote(rs.getInt("upvote_count"));
			question.setDownvote(rs.getInt("downvote_count"));
			question.setTimestamp(rs.getTimestamp("post_date")	);
			question.setContent(rs.getString("content"));
			question.setTopic(rs.getString("topic"));
			question.setVisibility(rs.getString("visibility"));
			question.setNo_of_answers(rs.getInt("no_of_answers"));
			questions.add(question);
			//System.out.println(rs.getTimestamp("post_date"));
			
		}
		statement.close();
		return questions;
	}
	
	@Override
	public List<Questions> getQuestionsOfUser(String user_id,String visibility,String[] topics) throws SQLException, ClassNotFoundException {
		
		List<Questions> questions=new ArrayList<Questions>();
		query="select * from questions where user_id=? and visibility=?";
		
		if(topics!=null && topics.length>0){
			query+=" and (topic like \'%"+topics[0].trim()+"%\'";
			for(int i=1;i<topics.length;i++){
				query+=" or topic like \'%"+topics[i].trim()+"%\'";
			}
			query+=")";
		}
		System.out.println(query);
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, user_id);
		statement.setString(2, visibility);
		

		ResultSet rs=statement.executeQuery();
		UserDAOImpl userDAO=new UserDAOImpl();
		while(rs.next()){
			Questions question=new Questions();
			question.setQuestion_No(rs.getInt("qno"));
			question.setUser_id(rs.getString("user_id"));
			question.setUpvote(rs.getInt("upvote_count"));
			question.setDownvote(rs.getInt("downvote_count"));
			question.setTimestamp(rs.getTimestamp("post_date")	);
			question.setContent(rs.getString("content"));
			question.setTopic(rs.getString("topic"));
			question.setVisibility(rs.getString("visibility"));
			question.setNo_of_answers(rs.getInt("no_of_answers"));
			question.setUser(userDAO.getUserDetails(rs.getString("user_id")));
			questions.add(question);
			
			
		}
		statement.close();
		return questions;
	}
	public Questions getQuestion(int question_no) throws SQLException{
		//System.out.println("DAO "+question_no);
		query="select * from questions where qno=?";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setInt(1, question_no);
		ResultSet rs=statement.executeQuery();
		if(rs.next()){
			Questions question=new Questions();
			question.setQuestion_No(rs.getInt("qno"));
			question.setUser_id(rs.getString("user_id"));
			question.setUpvote(rs.getInt("upvote_count"));
			question.setDownvote(rs.getInt("downvote_count"));
			question.setTimestamp(rs.getTimestamp("post_date")	);
			question.setContent(rs.getString("content"));
			question.setTopic(rs.getString("topic"));
			question.setVisibility(rs.getString("visibility"));
			question.setNo_of_answers(rs.getInt("no_of_answers"));
			return question;
		}
		else
			return null;
		
	}
		
	
	@Override
	public boolean updateQuestions(Questions questions) throws SQLException {
		query="update questions set upvote_count=?,downvote_count=?,content=?,topic=?,visibility=?,flagged=? where qno=?";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setInt(1, questions.getUpvote());
		statement.setInt(2, questions.getDownvote());
		statement.setString(3,questions.getContent());
		statement.setString(4,questions.getTopic());
		statement.setString(5,questions.getVisibility());
		statement.setBoolean(6,questions.getFlagged());
		statement.setInt(7,questions.getQuestion_No());
		int val=statement.executeUpdate();
		statement.close();
		if(val>0)
			return true;
		else
			return false;
	}
	@Override
	public boolean deleteQuestions(int qno) throws SQLException {
		query="delete from questions where qno=?";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setInt(1,qno);
		int val=statement.executeUpdate();
		statement.close();
		if(val>0)
			return true;
		else
			return false;
	}
	

}
