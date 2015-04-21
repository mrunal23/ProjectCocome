package com.cocome.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.cocome.DAO.Friends;
import com.cocome.DAO.FriendsDAOImpl;
import com.cocome.DAO.Questions;
import com.cocome.DAO.QuestionsDAOImpl;
import com.cocome.DAO.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FetchFriendsDiscussions extends ActionSupport {
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

	public String getFriendsDiscussions() throws ClassNotFoundException, SQLException {
		System.out.println("FetchFriendsDiscussions topics :"+topics);
		String[] discussionTopics=topics.split(",");
		Map session = ActionContext.getContext().getSession();
		User user=(User) session.get("user");
		FriendsDAOImpl friendsDAO=new FriendsDAOImpl();
		List<Friends> friendsList=friendsDAO.getFriendsOfUser(user.getUser_id());
		QuestionsDAOImpl questionsDAO=new QuestionsDAOImpl();
		List<Questions> questionFromFriend;
		questions=new ArrayList<Questions>();
		for(Friends friend: friendsList){
			questionFromFriend=questionsDAO.getQuestionsOfUser(friend.getUser().getUser_id(),"Friends",discussionTopics);
			questions.addAll(questionFromFriend);
		}
		
		Collections.sort(questions, new Comparator<Questions>() {
	        public int compare(Questions n1,  Questions n2) {
	            if (n1.getTimestamp() == null || n2.getTimestamp() == null)
	              return 0;
	            return n2.getTimestamp().compareTo(n1.getTimestamp());
	        }
	      });
		
		return SUCCESS;
		
	}
}
