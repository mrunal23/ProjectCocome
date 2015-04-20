package com.cocome.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.cocome.DAO.FriendRequests;
import com.cocome.DAO.FriendRequestsDAOImpl;
import com.cocome.DAO.Friends;
import com.cocome.DAO.FriendsDAOImpl;
import com.cocome.DAO.Login;
import com.cocome.DAO.Newsfeed;
import com.cocome.DAO.NewsfeedDAOImpl;
import com.cocome.DAO.Posts;
import com.cocome.DAO.PostsDAOImpl;
import com.cocome.DAO.Timeline;
import com.cocome.DAO.TimelineDAOImpl;
import com.cocome.DAO.User;
import com.cocome.DAO.UserDAOImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class loadEverythingAction extends ActionSupport {
	
	private Login login;
	private String name;
	private User user = null;
	private Integer countNewsfeeds;
	private Integer countTimelineEvents;
	private Integer countFriends;
	private Integer countSuggestedFriends;
	private Integer countFriendRequests;
	private List<Posts> posts;
	private List<Newsfeed> newsfeeds;	
	private List<Timeline> timelines;
	private List<Posts> postsUser;
	private List<Friends> friends;
	private List<FriendRequests> friendRequests;
	private List<Friends> friendsSuggested;
	
	public String execute() throws ClassNotFoundException, SQLException{
		String ret = SUCCESS;
		
		Map session = ActionContext.getContext().getSession();		
		user=(User)session.get("user");
		
		UserDAOImpl userDAO=new UserDAOImpl();
		user=userDAO.getUserDetails(user.getUser_id());
		
		setName(user.getFirst_name());
		
		session.put("user", user);
		
		NewsfeedDAOImpl newsfeedDAO=new NewsfeedDAOImpl();		
		newsfeeds = newsfeedDAO.getNewsfeedOfUser(user.getUser_id());
		
		PostsDAOImpl postsDAO=new PostsDAOImpl();
		posts = postsDAO.getPostsOfUsersFriends(user.getUser_id(), user.getLogout_time());
		
		countNewsfeeds = newsfeeds.size() + posts.size();
		
		PostsDAOImpl postsDAO1=new PostsDAOImpl();
		postsUser = postsDAO1.getPostsOfUser(user.getUser_id());
		
		TimelineDAOImpl timelineDAO = new TimelineDAOImpl();
		timelines = timelineDAO.getTimelineOfUser(user.getUser_id());
		
		countTimelineEvents = postsUser.size() + timelines.size();
		
		FriendsDAOImpl friendsDAO=new FriendsDAOImpl();			
		friends = friendsDAO.getFriendsOfUser(user.getUser_id());
		
		countFriends = friends.size();
		
		FriendRequestsDAOImpl friendRequestsDAO=new FriendRequestsDAOImpl();			
		friendRequests = friendRequestsDAO.getFriendRequestsForUser(user.getUser_id());
		
		countFriendRequests = friendRequests.size();
		
		FriendsDAOImpl friendsDAO1=new FriendsDAOImpl();			
		friendsSuggested = friendsDAO1.getSuggestedFriendsOfUser(user.getUser_id());
		
		countSuggestedFriends = friendsSuggested.size();
		
		return ret;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getCountNewsfeeds() {
		return countNewsfeeds;
	}

	public void setCountNewsfeeds(Integer countNewsfeeds) {
		this.countNewsfeeds = countNewsfeeds;
	}

	public Integer getCountTimelineEvents() {
		return countTimelineEvents;
	}

	public void setCountTimelineEvents(Integer countTimelineEvents) {
		this.countTimelineEvents = countTimelineEvents;
	}

	public Integer getCountFriends() {
		return countFriends;
	}

	public void setCountFriends(Integer countFriends) {
		this.countFriends = countFriends;
	}

	public Integer getCountSuggestedFriends() {
		return countSuggestedFriends;
	}

	public void setCountSuggestedFriends(Integer countSuggestedFriends) {
		this.countSuggestedFriends = countSuggestedFriends;
	}

	public Integer getCountFriendRequests() {
		return countFriendRequests;
	}

	public void setCountFriendRequests(Integer countFriendRequests) {
		this.countFriendRequests = countFriendRequests;
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

	public List<Timeline> getTimelines() {
		return timelines;
	}

	public void setTimelines(List<Timeline> timelines) {
		this.timelines = timelines;
	}

	public List<Posts> getPostsUser() {
		return postsUser;
	}

	public void setPostsUser(List<Posts> postsUser) {
		this.postsUser = postsUser;
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

	public List<Friends> getFriendsSuggested() {
		return friendsSuggested;
	}

	public void setFriendsSuggested(List<Friends> friendsSuggested) {
		this.friendsSuggested = friendsSuggested;
	}	
	
}
