package com.cocome.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

import com.cocome.DAO.Questions;
import com.cocome.DAO.QuestionsDAOImpl;
import com.opensymphony.xwork2.ActionSupport;

public class FlagValueUpdater extends ActionSupport {
	private String question_No;
	private String flagValue;
	private InputStream inputStream;
	
	public String getQuestion_No() {
		return question_No;
	}


	public void setQuestion_No(String question_No) {
		this.question_No = question_No;
	}


	public String getFlagValue() {
		return flagValue;
	}


	public void setFlagValue(String flagValue) {
		this.flagValue = flagValue;
	}

	
	public InputStream getInputStream() {
		return inputStream;
	}


	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}


	public String updateFlagValue() throws ClassNotFoundException, SQLException{
		
		QuestionsDAOImpl questionsDAO=new QuestionsDAOImpl();
		Questions question=questionsDAO.getQuestion(Integer.parseInt(question_No));
		
		
		if(flagValue.equals("1")){
			question.setFlagged(true);
			
		}
		else if(flagValue.equals("0")){
			question.setFlagged(false);
		}
		questionsDAO.updateQuestions(question);
		inputStream = new ByteArrayInputStream(
				"".getBytes(StandardCharsets.UTF_8));
		return SUCCESS;
		
	}
	
}
