package com.cocome.DAO;

import java.sql.SQLException;
import java.util.List;

public interface AnswersDAO {
	List<Answers> getAnswers(int qno) throws SQLException;
	boolean insertAnswers(Answers answers) throws SQLException;
    boolean updateAnswers(Answers answers) throws SQLException;
    boolean deleteAnswers(int ano) throws SQLException;
}
