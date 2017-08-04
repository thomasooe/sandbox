package com.tom.patterns.adapter;

public class Main {

	public static void main(String[] args) {
		Logger logger = Logger.create();
		
		logger.debug("Debug");
		logger.trace("Trace");
		logger.log("Log");
	}

}
