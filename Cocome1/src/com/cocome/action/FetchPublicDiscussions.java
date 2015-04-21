package com.cocome.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.cocome.DAO.Friends;
import com.cocome.DAO.GenericDAOImpl;
import com.cocome.DAO.Questions;
import com.cocome.DAO.QuestionsDAOImpl;
import com.cocome.DAO.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FetchPublicDiscussions extends ActionSupport {
	private List<Questions> questions;
	private String topics;
	public List<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}
	

	public String getTopics() {
		return topics;
	}

	public void setTopics(String topics) {
		this.topics = topics;
	}

	public String getPublicDiscussions() throws ClassNotFoundException,
			SQLException {
		System.out.println("Public : "+topics);
		String[] discussionTopics=topics.split(",");
		Map session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		GenericDAOImpl genericDAO = new GenericDAOImpl();
		List<String> publicUsers = genericDAO.getPublicUsers(user.getUser_id());
		QuestionsDAOImpl questionsDAO = new QuestionsDAOImpl();
		List<Questions> questionFromPublicUser;
		questions = new ArrayList<Questions>();
		for (String publicUser : publicUsers) {
			System.out.println("Public user : "+publicUser);
			questionFromPublicUser = questionsDAO.getQuestionsOfUser(publicUser, "Public",discussionTopics);
			questions.addAll(questionFromPublicUser);
		}

		Collections.sort(questions, new Comparator<Questions>() {
			public int compare(Questions n1, Questions n2) {
				if (n1.getTimestamp() == null || n2.getTimestamp() == null)
					return 0;
				return n2.getTimestamp().compareTo(n1.getTimestamp());
			}
		});

		return SUCCESS;

	}
}
