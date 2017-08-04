package com.tom.patterns.adapter;

public class LoggerImpl extends Logger {

	@Override
	public void trace(String str) {
		System.out.println("TRACE: ");
		System.out.println(str);
	}

	@Override
	public void debug(String str) {
		System.out.println("DEBUG: ");
		System.out.println(str);

	}

	@Override
	public void log(String str) {
		System.out.println("LOG: ");
		System.out.println(str);

	}

}
