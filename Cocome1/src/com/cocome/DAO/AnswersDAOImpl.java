package com.cocome.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class AnswersDAOImpl implements AnswersDAO {
	private Connection db_connection;
	private PreparedStatement statement;
	private String query;
	public AnswersDAOImpl() throws ClassNotFoundException, SQLException{
		db_connection=DBConnection_Singleton.getInstance().getDBConnection();
	}
	public boolean insertAnswers(String user_id,String content, int question_No) throws SQLException{
		query="insert into answers(user_id,content,qid) values(?,?,?)";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1,user_id);
		statement.setString(2, content);
		statement.setInt(3, question_No);
		int val=statement.executeUpdate();
		statement.close();
		if(val>0)
			return true;
		else
			return false;
	}
	
	@Override
	public List<Answers> getAnswers(int qno) throws SQLException, ClassNotFoundException {
		List<Answers> answers=new ArrayList<Answers>();
		query="select * from answers where qid=?";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setInt(1,qno);
		ResultSet rs=statement.executeQuery();
		UserDAOImpl userDAO=new UserDAOImpl();
		while(rs.next()){
			Answers answer=new Answers();
			answer.setAnswer_no(rs.getInt("ano"));
			answer.setQuestion_No(rs.getInt("qid"));
			//answer.setUser_id(rs.getString("user_id"));
			answer.setUpvote(rs.getInt("upvote_count"));
			answer.setDownvote(rs.getInt("downvote_count"));
			answer.setTimestamp(rs.getTimestamp("post_date"));
			answer.setContent(rs.getString("content"));
			answer.setUser(userDAO.getUserDetails(rs.getString("user_id")));
			answers.add(answer);
		}
		statement.close();
		return answers;
		
		
	}
	
	public Answers getAnswer(int answer_no) throws SQLException, ClassNotFoundException{
		//System.out.println("DAO "+question_no);
		query="select * from answers where ano=?";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setInt(1, answer_no);
		ResultSet rs=statement.executeQuery();
		UserDAOImpl userDAO=new UserDAOImpl();
		if(rs.next()){
			Answers answers=new Answers();
			answers.setQuestion_No(rs.getInt("ano"));
			//answers.setUser_id(rs.getString("user_id"));
			answers.setUpvote(rs.getInt("upvote_count"));
			answers.setDownvote(rs.getInt("downvote_count"));
			answers.setTimestamp(rs.getTimestamp("post_date"));
			answers.setContent(rs.getString("content"));
			answers.setQuestion_No(rs.getInt("qid"));
			answers.setUser(userDAO.getUserDetails(rs.getString("user_id")));
			return answers;
		}
		else
			return null;
		
	}
	
	@Override
	public boolean updateAnswers(Answers answers) throws SQLException {
		query="update answers set upvote_count=?,downvote_count=? where ano=?";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setInt(1, answers.getUpvote());
		statement.setInt(2, answers.getDownvote());
		statement.setInt(3,answers.getAnswer_no());
		
		int val=statement.executeUpdate();
		statement.close();
		if(val>0)
			return true;
		else
			return false;
	}
	@Override
	public boolean deleteAnswers(int ano) throws SQLException {
		query="delete from answers where ano=?";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setInt(1,ano);
		int val=statement.executeUpdate();
		statement.close();
		if(val>0)
			return true;
		else
			return false;
	}
}
