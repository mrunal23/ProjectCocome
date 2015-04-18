package com.cocome.action;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import com.cocome.DAO.Questions;
import com.cocome.DAO.QuestionsDAOImpl;
import com.cocome.DAO.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PostQuestionAction extends ActionSupport {
	//Questions question;
	String content;
	String topic;
	String visibility;
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
	

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
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
		question.setVisibility(visibility);
		Date currentDate=new Date();
		//SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		question.setTimestamp(new Timestamp(currentDate.getTime()));
		
		Map session = ActionContext.getContext().getSession();
		User user=(User) session.get("user");
		question.setUser_id(user.getUser_id());
		QuestionsDAOImpl ques=new QuestionsDAOImpl();
		
		
		ques.insertQuestions(question);
		return SUCCESS;
	}
	
}
