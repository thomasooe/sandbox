package com.tom.patterns.strategy;

public class User {
	private String name;
	
	public User(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void printJobComplete(Job j) {
		System.out.println("User Notified that Job completed");		
	}

}
