package com.cocome.DAO;

import java.sql.Timestamp;

public class Posts {
		private int post_id;
		private String user_id;
		private String content;
		private Timestamp post_date;
		private int likes_count;
		private int dislikes_count;
		public int getPost_id() {
			return post_id;
		}
		public void setPost_id(int post_id) {
			this.post_id = post_id;
		}
		public String getUser_id() {
			return user_id;
		}
		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public Timestamp getPost_date() {
			return post_date;
		}
		public void setPost_date(Timestamp post_date) {
			this.post_date = post_date;
		}
		public int getLikes_count() {
			return likes_count;
		}
		public void setLikes_count(int likes_count) {
			this.likes_count = likes_count;
		}
		public int getDislikes_count() {
			return dislikes_count;
		}
		public void setDislikes_count(int dislikes_count) {
			this.dislikes_count = dislikes_count;
		}


}
