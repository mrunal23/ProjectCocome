package com.cocome.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Map;

import com.cocome.DAO.Answers;
import com.cocome.DAO.AnswersDAOImpl;
import com.cocome.DAO.LikeDislikeRecordDAOImpl;
import com.cocome.DAO.User;
import com.opensymphony.xwork2.ActionContext;
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
		AnswersDAOImpl answersDAO = new AnswersDAOImpl();
		Answers answer = answersDAO.getAnswer(Integer
				.parseInt(answer_no.trim()));
			checkLike = likeDislikeRecordDAO.checkUserActivity(
					user.getUser_id(), 1, Integer.parseInt(answer_no.trim()),
					"upvote");
		
			checkDislike = likeDislikeRecordDAO.checkUserActivity(
					user.getUser_id(), 1, Integer.parseInt(answer_no.trim()),
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
			likeDislikeRecordDAO.deleteUserActivity(user.getUser_id(), 1, Integer.parseInt(answer_no.trim()), "upvote");
			likeDislikeRecordDAO.insert(1, Integer.parseInt(answer_no.trim()), user.getUser_id(),false , true);
			prevUpCount = answer.getUpvote();
			if(prevUpCount!=0)
				updatedUpCount = prevUpCount - 1;
			answer.setUpvote(updatedUpCount);
			
			prevDownCount = answer.getDownvote();
			updatedDownCount = prevDownCount + 1;
			answer.setDownvote(updatedDownCount);

			result = "Upvote " + updatedUpCount + " Downvote "
					+ updatedDownCount;
		} else if (checkDislike && type.equals("upvote")) {
			likeDislikeRecordDAO.deleteUserActivity(user.getUser_id(), 1, Integer.parseInt(answer_no.trim()), "downvote");
			likeDislikeRecordDAO.insert(1, Integer.parseInt(answer_no.trim()), user.getUser_id(),true , false);
			prevUpCount = answer.getUpvote();
			updatedUpCount = prevUpCount + 1;
			answer.setUpvote(updatedUpCount);
			
			
			prevDownCount = answer.getDownvote();
			if(prevDownCount!=0)
				updatedDownCount = prevDownCount - 1;
			answer.setDownvote(updatedDownCount);

			result = "Upvote " + updatedUpCount + " Downvote "
					+ updatedDownCount;

		} else if (!checkLike && !checkDislike) {
			
			if (type.equals("upvote")) {
				prevUpCount = answer.getUpvote();
				updatedUpCount = prevUpCount + 1;
				answer.setUpvote(updatedUpCount);
				result = "Upvote " + updatedUpCount;
				likeDislikeRecordDAO.insert(1, Integer.parseInt(answer_no.trim()), user.getUser_id(),true , false);

			} else {
				prevDownCount = answer.getDownvote();
				updatedDownCount = prevDownCount + 1;
				answer.setDownvote(updatedDownCount);
				result = "Downvote " + updatedDownCount;
				likeDislikeRecordDAO.insert(1, Integer.parseInt(answer_no.trim()), user.getUser_id(),false , true);
			}
			
			

		}
		answer.setAnswer_no(Integer.parseInt(answer_no.trim()));
		answersDAO.updateAnswers(answer);

		inputStream = new ByteArrayInputStream(
				result.getBytes(StandardCharsets.UTF_8));
		//System.out.println("Check Like "+checkLike);
		//System.out.println("Check DisLike "+checkDislike);

		return SUCCESS;
		
		
		
		
		
		
		
		//System.out.println("HIII: "+answer_no);
//		AnswersDAOImpl answersDAO = new AnswersDAOImpl();
//		Answers answer = answersDAO.getAnswer(Integer.parseInt(answer_no.trim()));
//		int prevCount;
//		int updatedCount;
//		answer.setAnswer_no(Integer.parseInt(answer_no.trim()));
//		if (type.equals("upvote")) {
//			
//			prevCount = answer.getUpvote();
//			updatedCount = prevCount + 1;
//			answer.setUpvote(updatedCount);
//		} else {
//			
//			prevCount = answer.getDownvote();
//			updatedCount = prevCount - 1;
//			answer.setDownvote(updatedCount);
//		}
//		answersDAO.updateAnswers(answer);
//		
//		inputStream = new ByteArrayInputStream(String.valueOf(updatedCount)
//				.getBytes(StandardCharsets.UTF_8));
//		
//		return SUCCESS;
	}
}
