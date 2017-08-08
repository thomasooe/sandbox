package com.tom.patterns.templatemethod;

public class Result {

	private String content;
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void printOutput() {
		System.out.println(this.getContent());
	}

}
