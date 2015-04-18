package com.cocome.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Map;

import com.cocome.DAO.AnswersDAOImpl;
import com.cocome.DAO.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CommentsUpdater extends ActionSupport {
	private String question_No;
	private String comment;
	private String no_of_answers;
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
	

public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

public String getNo_of_answers() {
		return no_of_answers;
	}

	public void setNo_of_answers(String no_of_answers) {
		this.no_of_answers = no_of_answers;
	}

public String addComment() throws ClassNotFoundException, SQLException{
//	System.out.println("AJAX "+question_No);
//	System.out.println("TYPE "+type);
	Map session = ActionContext.getContext().getSession();
	User user=(User) session.get("user");
	AnswersDAOImpl answersDAO=new AnswersDAOImpl();
	String user_id=user.getUser_id();
	answersDAO.insertAnswers(user_id, comment, Integer.parseInt(question_No));
	int totalComments=Integer.parseInt(no_of_answers)+1;
	inputStream = new ByteArrayInputStream(String.valueOf(totalComments).getBytes(StandardCharsets.UTF_8));
	
    return SUCCESS;
}
}
