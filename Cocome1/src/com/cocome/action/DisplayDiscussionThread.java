package com.cocome.action;

import java.sql.SQLException;

import com.cocome.DAO.Questions;
import com.cocome.DAO.QuestionsDAOImpl;
import com.opensymphony.xwork2.ActionSupport;

public class DisplayDiscussionThread extends ActionSupport {
	private int question_No;
	private String content;
	private int upvote;
	private int downvote;
	private int no_of_answers;
	
	public int getQuestion_No() {
		return question_No;
	}

	public void setQuestion_No(int question_No) {
		this.question_No = question_No;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUpvote() {
		return upvote;
	}

	public void setUpvote(int upvote) {
		this.upvote = upvote;
	}

	public int getDownvote() {
		return downvote;
	}

	public void setDownvote(int downvote) {
		this.downvote = downvote;
	}
	
	

	public int getNo_of_answers() {
		return no_of_answers;
	}

	public void setNo_of_answers(int no_of_answers) {
		this.no_of_answers = no_of_answers;
	}

	public String displayThreadContent() throws ClassNotFoundException, SQLException{

		QuestionsDAOImpl questionsDAO=new QuestionsDAOImpl();
		Questions ques=questionsDAO.getQuestion(question_No);
		setContent(ques.getContent());
		setUpvote(ques.getUpvote());
		setDownvote(ques.getDownvote());
		setNo_of_answers(ques.getNo_of_answers());
		//System.out.println(no_of_answers);
		return SUCCESS;
			}

		
		
	}

