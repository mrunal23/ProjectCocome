package com.cocome.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Map;

import com.cocome.DAO.LikeDislikeRecordDAOImpl;
import com.cocome.DAO.Questions;
import com.cocome.DAO.QuestionsDAOImpl;
import com.cocome.DAO.User;
import com.opensymphony.xwork2.ActionContext;
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

	public String updateVotes() throws ClassNotFoundException, SQLException {
		//System.out.println("Action entry");
		Map session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		boolean checkLike = false;
		boolean checkDislike = false;
		int prevUpCount=0;
		int updatedUpCount=0;
		int prevDownCount=0;
		int updatedDownCount=0;
		String result="";
		LikeDislikeRecordDAOImpl likeDislikeRecordDAO = new LikeDislikeRecordDAOImpl();
		QuestionsDAOImpl questionsDAO = new QuestionsDAOImpl();
		Questions question = questionsDAO.getQuestion(Integer
				.parseInt(question_No.trim()));
			checkLike = likeDislikeRecordDAO.checkUserActivity(
					user.getUser_id(), 0, Integer.parseInt(question_No.trim()),
					"upvote");
		
			checkDislike = likeDislikeRecordDAO.checkUserActivity(
					user.getUser_id(), 0, Integer.parseInt(question_No.trim()),
					"downvote");

		if (checkLike && type.equals("upvote")) {
			result = "upvoteFail";
			// inputStream = new
			// ByteArrayInputStream("upvoteFail".getBytes(StandardCharsets.UTF_8));
		} else if (checkDislike && type.equals("downvote")) {
			result = "downvoteFail";
			// inputStream = new
			// ByteArrayInputStream("downvoteFail".getBytes(StandardCharsets.UTF_8));
		} else if (checkLike && type.equals("downvote")) {
			likeDislikeRecordDAO.deleteUserActivity(user.getUser_id(), 0, Integer.parseInt(question_No.trim()), "upvote");
			likeDislikeRecordDAO.insert(0, Integer.parseInt(question_No.trim()), user.getUser_id(),false , true);
			prevUpCount = question.getUpvote();
			if(prevUpCount!=0)
				updatedUpCount = prevUpCount - 1;
			question.setUpvote(updatedUpCount);
			
			prevDownCount = question.getDownvote();
			updatedDownCount = prevDownCount + 1;
			question.setDownvote(updatedDownCount);

			result = "Upvote " + updatedUpCount + " Downvote "
					+ updatedDownCount;
		} else if (checkDislike && type.equals("upvote")) {
			likeDislikeRecordDAO.deleteUserActivity(user.getUser_id(), 0, Integer.parseInt(question_No.trim()), "downvote");
			likeDislikeRecordDAO.insert(0, Integer.parseInt(question_No.trim()), user.getUser_id(),true , false);
			prevUpCount = question.getUpvote();
			updatedUpCount = prevUpCount + 1;
			question.setUpvote(updatedUpCount);
			
			
			prevDownCount = question.getDownvote();
			if(prevDownCount!=0)
				updatedDownCount = prevDownCount - 1;
			question.setDownvote(updatedDownCount);

			result = "Upvote " + updatedUpCount + " Downvote "
					+ updatedDownCount;

		} else if (!checkLike && !checkDislike) {
			
			if (type.equals("upvote")) {
				prevUpCount = question.getUpvote();
				updatedUpCount = prevUpCount + 1;
				question.setUpvote(updatedUpCount);
				result = "Upvote " + updatedUpCount;
				likeDislikeRecordDAO.insert(0, Integer.parseInt(question_No.trim()), user.getUser_id(),true , false);

			} else {
				prevDownCount = question.getDownvote();
				updatedDownCount = prevDownCount + 1;
				question.setDownvote(updatedDownCount);
				result = "Downvote " + updatedDownCount;
				likeDislikeRecordDAO.insert(0, Integer.parseInt(question_No.trim()), user.getUser_id(),false , true);
			}
			
			

		}

		questionsDAO.updateQuestions(question);

		inputStream = new ByteArrayInputStream(
				result.getBytes(StandardCharsets.UTF_8));
		//System.out.println("Check Like "+checkLike);
		//System.out.println("Check DisLike "+checkDislike);

		return SUCCESS;
	}
}
