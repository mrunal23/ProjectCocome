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
	QuestionsDAOImpl() throws ClassNotFoundException, SQLException{
		db_connection=DBConnection_Singleton.getInstance().getDBConnection();
	}
	public boolean insertQuestions(Questions questions) throws SQLException{
		query="insert into questions(user_id,upvote_count,downvote_count,post_date,content,topic) values(?,?,?,?,?,?)";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1,questions.getUser_id());
		statement.setInt(2, questions.getUpvote());
		statement.setInt(3, questions.getDownvote());
		statement.setDate(4,questions.getTimestamp());
		statement.setString(5, questions.getContent());
		statement.setString(6, questions.getTopic());
		int val=statement.executeUpdate();
		statement.close();
		if(val>0)
			return true;
		else
			return false;
	}
	
	@Override
	public List<Questions> getQuestionsOfUser(String user_id) throws SQLException {
		List<Questions> questions=new ArrayList<Questions>();
		query="select * from questions where user_id=?";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, "user_id");
		ResultSet rs=statement.executeQuery();
		while(rs.next()){
			Questions question=new Questions();
			question.setQuestion_No(rs.getInt("qno"));
			question.setUser_id(rs.getString("user_id"));
			question.setUpvote(rs.getInt("upvote_count"));
			question.setDownvote(rs.getInt("downvote_count"));
			question.setTimestamp(rs.getDate("post_date"));
			question.setContent(rs.getString("content"));
			question.setTopic(rs.getString("topic"));
			questions.add(question);
		}
		statement.close();
		return questions;
		
		
	}
	@Override
	public boolean updateQuestions(Questions questions) throws SQLException {
		query="update questions set upvote_count=?,downvote_count=?,content=?,topic=? where qno=?";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setInt(1, questions.getUpvote());
		statement.setInt(2, questions.getDownvote());
		statement.setString(3,questions.getContent());
		statement.setString(4,questions.getTopic());
		statement.setInt(5,questions.getQuestion_No());
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
