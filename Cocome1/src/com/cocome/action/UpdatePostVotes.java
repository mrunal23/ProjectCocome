package com.cocome.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Map;

import com.cocome.DAO.LikeDislikeRecordDAOImpl;
import com.cocome.DAO.Posts;
import com.cocome.DAO.PostsDAOImpl;
import com.cocome.DAO.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdatePostVotes extends ActionSupport {
	private String post_id;
	private String type;
	private InputStream inputStream;
	
	

	public String getPost_id() {
		return post_id;
	}

	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}





	public String updatePostVotes() throws ClassNotFoundException, SQLException {
		System.out.println("Inside AJAX Action");
		System.out.println("Post ID "+post_id);
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
		PostsDAOImpl postsDAO = new PostsDAOImpl();
		Posts post = postsDAO.getPost(Integer
				.parseInt(post_id.trim()));
			checkLike = likeDislikeRecordDAO.checkUserActivity(
					user.getUser_id(), 2, Integer.parseInt(post_id.trim()),
					"upvote");
		
			checkDislike = likeDislikeRecordDAO.checkUserActivity(
					user.getUser_id(), 2, Integer.parseInt(post_id.trim()),
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
			likeDislikeRecordDAO.deleteUserActivity(user.getUser_id(), 2, Integer.parseInt(post_id.trim()), "upvote");
			likeDislikeRecordDAO.insert(2, Integer.parseInt(post_id.trim()), user.getUser_id(),false , true);
			prevUpCount = post.getLikes_count();
			if(prevUpCount!=0)
				updatedUpCount = prevUpCount - 1;
			post.setLikes_count(updatedUpCount);
			
			prevDownCount = post.getDislikes_count();
			updatedDownCount = prevDownCount + 1;
			post.setDislikes_count(updatedDownCount);

			result = "Upvote " + updatedUpCount + " Downvote "
					+ updatedDownCount;
		} else if (checkDislike && type.equals("upvote")) {
			likeDislikeRecordDAO.deleteUserActivity(user.getUser_id(), 2, Integer.parseInt(post_id.trim()), "downvote");
			likeDislikeRecordDAO.insert(2, Integer.parseInt(post_id.trim()), user.getUser_id(),true , false);
			prevUpCount = post.getLikes_count();
			updatedUpCount = prevUpCount + 1;
			post.setLikes_count(updatedUpCount);
			
			
			prevDownCount = post.getDislikes_count();
			if(prevDownCount!=0)
				updatedDownCount = prevDownCount - 1;
			post.setDislikes_count(updatedDownCount);

			result = "Upvote " + updatedUpCount + " Downvote "
					+ updatedDownCount;

		} else if (!checkLike && !checkDislike) {
			
			if (type.equals("upvote")) {
				prevUpCount = post.getDislikes_count();
				updatedUpCount = prevUpCount + 1;
				post.setLikes_count(updatedUpCount);
				result = "Upvote " + updatedUpCount;
				likeDislikeRecordDAO.insert(2, Integer.parseInt(post_id.trim()), user.getUser_id(),true , false);

			} else {
				prevDownCount = post.getDislikes_count();
				updatedDownCount = prevDownCount + 1;
				post.setDislikes_count(updatedDownCount);
				result = "Downvote " + updatedDownCount;
				likeDislikeRecordDAO.insert(2, Integer.parseInt(post_id.trim()), user.getUser_id(),false , true);
			}
			
			

		}
		post.setPost_id(Integer.parseInt(post_id.trim()));
		postsDAO.updatePosts(post);

		inputStream = new ByteArrayInputStream(
				result.getBytes(StandardCharsets.UTF_8));
		

		return SUCCESS;
	}
}
