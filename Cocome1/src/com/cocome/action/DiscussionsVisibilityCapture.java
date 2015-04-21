package com.cocome.action;

import com.opensymphony.xwork2.ActionSupport;

public class DiscussionsVisibilityCapture extends ActionSupport {
	String source;
	
public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

public String captureDiscussionSource(){
	System.out.println("DiscussionsVisibilityCapture : "+source);
	return SUCCESS;
}
}
