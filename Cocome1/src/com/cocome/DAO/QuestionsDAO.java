package com.cocome.DAO;

import java.sql.SQLException;
import java.util.List;

public interface QuestionsDAO {
	List<Questions> getQuestionsOfUser(String user_id) throws SQLException, ClassNotFoundException;
	Questions getQuestion(int question_no) throws SQLException;
	boolean insertQuestions(Questions questions) throws SQLException;
    boolean updateQuestions(Questions questions) throws SQLException;
    boolean deleteQuestions( int qno) throws SQLException;
    List<Questions> getQuestionsOfUser(String user_id,String visibility,String[] topics) throws SQLException, ClassNotFoundException;
    
}
