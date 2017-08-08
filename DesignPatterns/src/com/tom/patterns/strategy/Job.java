package com.tom.patterns.strategy;

public class Job {
	private static int JOB_NUMBER = 1;
	private int id = JOB_NUMBER++;
	private User user;
	private String content;
	private final static int DEFAULT_PRIORITY = 50;
	private int priority = DEFAULT_PRIORITY;
	
	public Job(String content) {
		this.setUser(null);
		this.setContent(content);
	}
	
	public Job(String content, int priority) {
		this.setUser(null);
		this.setContent(content);
		this.priority = priority;
	}
	
	public Job(User user, String content) {
		this.setUser(user);
		this.setContent(content);
	}
	
	public Job(User user, String content, int priority) {
		this.setUser(user);
		this.setContent(content);
		this.priority = priority;
	}
	
	public int getPriority() {
		return this.priority;
	}
	public int getId() {
		return this.id;
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
