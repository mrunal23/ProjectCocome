package com.cocome.DAO;

import java.sql.Timestamp;

public class Timeline {
		private String type_of_feed;

		private String content;
		private Timestamp date;
		private String likes;
		private String dislikes;
		private String comment;
		public String getType_of_feed() {
			return type_of_feed;
		}
		public void setType_of_feed(String type_of_feed) {
			this.type_of_feed = type_of_feed;
		}
		
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public Timestamp getDate() {
			return date;
		}
		public void setDate(Timestamp date) {
			this.date = date;
		}
		public String getLikes() {
			return likes;
		}
		public void setLikes(String likes) {
			this.likes = likes;
		}
		public String getDislikes() {
			return dislikes;
		}
		public void setDislikes(String dislikes) {
			this.dislikes = dislikes;
		}
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
		}

		
}
