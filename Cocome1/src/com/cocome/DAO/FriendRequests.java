package com.cocome.DAO;

import java.sql.Timestamp;

public class FriendRequests {
		private User request_from_user;
		private String request_to;
		private int approved;

		public String getRequest_to() {
			return request_to;
		}
		public void setRequest_to(String request_to) {
			this.request_to = request_to;
		}
		public int getApproved() {
			return approved;
		}
		public void setApproved(int approved) {
			this.approved = approved;
		}
		public User getRequest_from_user() {
			return request_from_user;
		}
		public void setRequest_from_user(User request_from_user) {
			this.request_from_user = request_from_user;
		}



		

}
