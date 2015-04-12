package com.cocome.DAO;

import java.sql.SQLException;
import java.util.List;

public interface QuestionsDAO {
	List<Questions> getQuestionsOfUser(String user_id) throws SQLException;
	boolean insertQuestions(Questions questions) throws SQLException;
    boolean updateQuestions(Questions questions) throws SQLException;
    boolean deleteQuestions( int qno) throws SQLException;
}
