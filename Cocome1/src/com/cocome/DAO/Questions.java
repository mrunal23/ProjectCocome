package com.cocome.DAO;

import java.sql.Date;

public class Questions {
		private int question_No;
		private String user_id;
		private int upvote;
		private int downvote;
		private Date timestamp;
		private String content;
		private String topic;
		public int getQuestion_No() {
			return question_No;
		}
		public void setQuestion_No(int question_No) {
			this.question_No = question_No;
		}
		
		public String getUser_id() {
			return user_id;
		}
		public void setUser_id(String user_id) {
			this.user_id = user_id;
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
		public Date getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(Date timestamp) {
			this.timestamp = timestamp;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getTopic() {
			return topic;
		}
		public void setTopic(String topic) {
			this.topic = topic;
		}

}
