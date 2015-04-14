package com.cocome.action;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import com.cocome.DAO.Questions;
import com.cocome.DAO.QuestionsDAOImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PostQuestionAction extends ActionSupport {
	//Questions question;
	String content;
	String topic;
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
		//System.out.println(topic);
		//System.out.println(question.getTopic());
	}

public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	//	public Questions getQuestion() {
//		System.out.println(question.getTopic());
//		return question;
//	}
//
//	public void setQuestion(Questions question) {
//		this.question = question;
//	}
	public String postDiscussion() throws ParseException, ClassNotFoundException, SQLException{
		Questions question=new Questions();
		question.setContent(content);
		question.setTopic(topic);
		question.setDownvote(0);
		question.setUpvote(0);
		
		Date currentDate=new Date();
		//SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		question.setTimestamp(new Timestamp(currentDate.getTime()));
		question.setUser_id("bde@indiana.edu");
		QuestionsDAOImpl ques=new QuestionsDAOImpl();
		Map session = ActionContext.getContext().getSession();
		session.put("Name","Bipra" );
		
		ques.insertQuestions(question);
		return SUCCESS;
	}
	
}
