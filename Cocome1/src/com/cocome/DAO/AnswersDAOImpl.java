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
	AnswersDAOImpl() throws ClassNotFoundException, SQLException{
		db_connection=DBConnection_Singleton.getInstance().getDBConnection();
	}
	public boolean insertAnswers(Answers answers) throws SQLException{
		query="insert into answers(user_id,upvote_count,downvote_count,post_date,content,qid) values(?,?,?,?,?,?)";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1,answers.getUser_id());
		statement.setInt(2, answers.getUpvote());
		statement.setInt(3, answers.getDownvote());
		statement.setDate(4,answers.getTimestamp());
		statement.setString(5, answers.getContent());
		statement.setInt(6, answers.getQuestion_No());
		int val=statement.executeUpdate();
		statement.close();
		if(val>0)
			return true;
		else
			return false;
	}
	
	@Override
	public List<Answers> getAnswers(int qno) throws SQLException {
		List<Answers> answers=new ArrayList<Answers>();
		query="select * from answers where qid=?";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setInt(1,qno);
		ResultSet rs=statement.executeQuery();
		while(rs.next()){
			Answers answer=new Answers();
			answer.setAnswer_no(rs.getInt("ano"));
			answer.setQuestion_No(rs.getInt("qid"));
			answer.setUser_id(rs.getString("user_id"));
			answer.setUpvote(rs.getInt("upvote_count"));
			answer.setDownvote(rs.getInt("downvote_count"));
			answer.setTimestamp(rs.getDate("post_date"));
			answer.setContent(rs.getString("content"));
			answers.add(answer);
		}
		statement.close();
		return answers;
		
		
	}
	@Override
	public boolean updateAnswers(Answers answers) throws SQLException {
		query="update answers set upvote_count=?,downvote_count=?,content=? where qno=?";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setInt(1, answers.getUpvote());
		statement.setInt(2, answers.getDownvote());
		statement.setString(3,answers.getContent());
		statement.setInt(4,answers.getQuestion_No());
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
