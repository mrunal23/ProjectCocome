package com.cocome.action;

import com.opensymphony.xwork2.ActionSupport;

public class DiscussionsRedirector extends ActionSupport {
	String source;
	String topics;
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	

	public String getTopics() {
		return topics;
	}

	public void setTopics(String topics) {
		this.topics = topics;
	}

	public String fetchDissuccionsVisibility(){
		System.out.println("DiscussionsRedirector Source: "+source+" topics :"+topics);
	return source;
}
}
