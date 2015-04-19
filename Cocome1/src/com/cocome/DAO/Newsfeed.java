package com.cocome.DAO;

import java.sql.Timestamp;

public class Newsfeed {
		private String type_of_feed;
		private String posted_by;
		private String content;
		private Timestamp date;
		private String likes_count;
		private String dislikes_count;
		private String comment_count;
		public String getType_of_feed() {
			return type_of_feed;
		}
		public String getLikes_count() {
			return likes_count;
		}
		public void setLikes_count(String likes_count) {
			this.likes_count = likes_count;
		}
		public String getDislikes_count() {
			return dislikes_count;
		}
		public void setDislikes_count(String dislikes_count) {
			this.dislikes_count = dislikes_count;
		}
		public String getComment_count() {
			return comment_count;
		}
		public void setComment_count(String comment_count) {
			this.comment_count = comment_count;
		}
		public void setType_of_feed(String type_of_feed) {
			this.type_of_feed = type_of_feed;
		}
		public String getPosted_by() {
			return posted_by;
		}
		public void setPosted_by(String posted_by) {
			this.posted_by = posted_by;
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

}
