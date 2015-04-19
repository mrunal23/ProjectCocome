package com.cocome.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.cocome.DAO.FriendRequests;
import com.cocome.DAO.FriendRequestsDAOImpl;
import com.cocome.DAO.Friends;
import com.cocome.DAO.FriendsDAOImpl;
import com.cocome.DAO.Newsfeed;
import com.cocome.DAO.NewsfeedDAOImpl;
import com.cocome.DAO.Posts;
import com.cocome.DAO.PostsDAOImpl;
import com.cocome.DAO.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport {
	
	private List<Posts> posts;
	private List<Newsfeed> newsfeeds;
	private List<Friends> friends;
	private List<FriendRequests> friendRequests;
	private User user;
	
	

	public String newsfeedAction()throws ClassNotFoundException, SQLException{
		Map session = ActionContext.getContext().getSession();
		user=(User) session.get("user");
		
		NewsfeedDAOImpl newsfeedDAO=new NewsfeedDAOImpl();
		
		newsfeeds = newsfeedDAO.getNewsfeedOfUser(user.getUser_id());
		System.out.println("Newsfeed of the given user");
		for(Newsfeed q:newsfeeds){
			System.out.println(q.getPosted_by());
			System.out.println(q.getContent());
		}
		//session.put("user_newsfeed", newsfeeds); 
		return SUCCESS;			
	}
	
	
	/**
	 * Implementing Timeline
	 * 
	 * */
	public String timelineAction() throws ClassNotFoundException, SQLException {
		
		Map session = ActionContext.getContext().getSession();
		user=(User) session.get("user");
		System.out.println(user.getUser_id());
		PostsDAOImpl postsDAO=new PostsDAOImpl();
		posts = postsDAO.getPostsOfUser(user.getUser_id());
		System.out.println("Posts of the given user");
		for(Posts q:posts){
			System.out.println(q.getPost_id());
		}
		//session.put("user_posts", posts); 
		return SUCCESS;		
	}
	
	public String suggestedFriendsAction(){
		String ret = SUCCESS;
	    
	      return ret;		
	}
	
	public String friendsOnlineAction(){
		String ret = SUCCESS;
	    
	      return ret;		
	}
	
	public String somethingAction(){
		String ret = SUCCESS;
	    
	      return ret;		
	}
	
	public String viewDiscussionsAction(){
		String ret = SUCCESS;
	    
	      return ret;		
	}
	
	public String postQuestionAction(){
		String ret = SUCCESS;
	    
	      return ret;		
	}
	

	
	public String myFriendsAction()throws ClassNotFoundException, SQLException{
		Map session = ActionContext.getContext().getSession();
		user=(User) session.get("user");		
		FriendsDAOImpl friendsDAO=new FriendsDAOImpl();
		
		friends = friendsDAO.getFriendsOfUser(user.getUser_id());
		
//		for(Newsfeed q:newsfeeds){
//			System.out.println(q.getPosted_by());
//			System.out.println(q.getContent());
//		}
		//session.put("user_newsfeed", newsfeeds); 
		return SUCCESS;				
	}
	
	public String friendsNotificationAction() throws ClassNotFoundException, SQLException{
		Map session = ActionContext.getContext().getSession();
		user=(User) session.get("user");
		
		FriendRequestsDAOImpl friendRequestsDAO=new FriendRequestsDAOImpl();
		
		friendRequests = friendRequestsDAO.getFriendRequestsForUser(user.getUser_id());
		System.out.println("Newsfeed of the given user");
//		for(Newsfeed q:newsfeeds){
//			System.out.println(q.getPosted_by());
//			System.out.println(q.getContent());
//		}
		//session.put("user_newsfeed", newsfeeds); 
		return SUCCESS;		
	}


	public List<Posts> getPosts() {
		return posts;
	}


	public void setPosts(List<Posts> posts) {
		this.posts = posts;
	}
	
	public List<Newsfeed> getNewsfeeds() {
		return newsfeeds;
	}


	public void setNewsfeeds(List<Newsfeed> newsfeeds) {
		this.newsfeeds = newsfeeds;
	}



	public List<Friends> getFriends() {
		return friends;
	}


	public void setFriends(List<Friends> friends) {
		this.friends = friends;
	}


	public List<FriendRequests> getFriendRequests() {
		return friendRequests;
	}


	public void setFriendRequests(List<FriendRequests> friendRequests) {
		this.friendRequests = friendRequests;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
