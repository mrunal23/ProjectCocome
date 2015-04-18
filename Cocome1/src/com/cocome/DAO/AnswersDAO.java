package com.cocome.DAO;

import java.sql.SQLException;
import java.util.List;

public interface AnswersDAO {
	List<Answers> getAnswers(int qno) throws SQLException,ClassNotFoundException;
	boolean insertAnswers(String user_id,String content, int question_No) throws SQLException;
    boolean updateAnswers(Answers answers) throws SQLException;
    boolean deleteAnswers(int ano) throws SQLException;
    Answers getAnswer(int answer_no) throws SQLException,ClassNotFoundException;
    
}
