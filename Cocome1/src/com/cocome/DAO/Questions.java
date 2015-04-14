package com.cocome.DAO;

import java.sql.Timestamp;

public class Questions {
		private int question_No;
		private String user_id;
		private int upvote;
		private int downvote;
		private Timestamp timestamp;
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
		public Timestamp getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(Timestamp timestamp) {
			this.timestamp = timestamp;
		}
		public String getContent() {
			
			return content;
		}
		public void setContent(String content) {
			System.out.println(content);
			this.content = content;
		}
		public String getTopic() {
			return topic;
		}
		public void setTopic(String topic) {
			System.out.println(topic);
			this.topic = topic;
		}
//		public void forwardQuestion(){
//			Map session = ActionContext.getContext().getSession();
//			session.put("Question", value)
//		}

}
