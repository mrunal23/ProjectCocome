package com.cocome.action;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.cocome.DAO.Answers;
import com.cocome.DAO.AnswersDAOImpl;
import com.opensymphony.xwork2.ActionSupport;

public class FetchComments extends ActionSupport {
	private String question_No;
	private List<Answers> answers;
	
	public String getQuestion_No() {
		return question_No;
	}

	public void setQuestion_No(String question_No) {
		this.question_No = question_No;
	}
	
	public List<Answers> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answers> answers) {
		this.answers = answers;
	}

	public String fetchComments() throws ClassNotFoundException, SQLException{
		AnswersDAOImpl answersDAO=new AnswersDAOImpl();
		answers=answersDAO.getAnswers(Integer.parseInt(question_No));
		Collections.sort(answers, new Comparator<Answers>() {
	        public int compare(Answers n1,  Answers n2) {
	            if (n1.getTimestamp() == null || n2.getTimestamp() == null)
	              return 0;
	            return n2.getTimestamp().compareTo(n1.getTimestamp());
	        }
	      });
		
		return SUCCESS;
		
	}
	
	
}
