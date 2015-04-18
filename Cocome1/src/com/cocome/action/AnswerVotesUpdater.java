package com.cocome.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

import com.cocome.DAO.Answers;
import com.cocome.DAO.AnswersDAOImpl;
import com.opensymphony.xwork2.ActionSupport;

public class AnswerVotesUpdater extends ActionSupport {
	private String answer_no;
	private String type;
	private InputStream inputStream;

	public String getAnswer_no() {
		return answer_no;
	}

	public void setAnswer_no(String answer_no) {
		this.answer_no = answer_no;
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

	public String updateAnswerVotes() throws ClassNotFoundException, SQLException {
		//System.out.println("HIII: "+answer_no);
		AnswersDAOImpl answersDAO = new AnswersDAOImpl();
		Answers answer = answersDAO.getAnswer(Integer.parseInt(answer_no.trim()));
		int prevCount;
		int updatedCount;
		answer.setAnswer_no(Integer.parseInt(answer_no.trim()));
		if (type.equals("upvote")) {
			
			prevCount = answer.getUpvote();
			updatedCount = prevCount + 1;
			answer.setUpvote(updatedCount);
		} else {
			
			prevCount = answer.getDownvote();
			updatedCount = prevCount - 1;
			answer.setDownvote(updatedCount);
		}
		answersDAO.updateAnswers(answer);
		
		inputStream = new ByteArrayInputStream(String.valueOf(updatedCount)
				.getBytes(StandardCharsets.UTF_8));
		
		return SUCCESS;
	}
}
