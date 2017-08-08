package com.tom.patterns.strategy;

public class Job {
	private String id;
	private User user;
	private String content;
	
	public Job(User user, String content, int id) {
		this.setUser(user);
		this.setContent(content);
		this.setId(String.valueOf(id));
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
