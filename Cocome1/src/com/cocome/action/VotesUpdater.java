package com.cocome.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

import com.cocome.DAO.Questions;
import com.cocome.DAO.QuestionsDAOImpl;
import com.opensymphony.xwork2.ActionSupport;

public class VotesUpdater extends ActionSupport {
	private String question_No;
	private String type;
	private InputStream inputStream;
	public String getQuestion_No() {
		return question_No;
	}

	public void setQuestion_No(String question_No) {
		this.question_No = question_No;
	}

public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	

public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

public String updateVotes() throws ClassNotFoundException, SQLException{
//	System.out.println("AJAX "+question_No);
//	System.out.println("TYPE "+type);
	QuestionsDAOImpl questionsDAO=new QuestionsDAOImpl();
	Questions question=questionsDAO.getQuestion(Integer.parseInt(question_No.trim()));
	int prevCount;
	int updatedCount;
//	System.out.println(prevCount);
	if(type.equals("upvote")){
		prevCount=question.getUpvote();
		updatedCount=prevCount+1;
		question.setUpvote(updatedCount);
	}
	else{
		prevCount=question.getDownvote();
		updatedCount=prevCount-1;
		question.setDownvote(updatedCount);
	}
	
	questionsDAO.updateQuestions(question);
	//if(questionsDAO.updateQuestions(questions))
	inputStream = new ByteArrayInputStream(String.valueOf(updatedCount).getBytes(StandardCharsets.UTF_8));
	//System.out.println("HIII: "+question_No);
    return SUCCESS;
}
}
