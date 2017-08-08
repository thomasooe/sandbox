package com.tom.patterns.templatemethod;

public class Connection {

	public Result executeQuery(String query) {
		Result r = new Result();
		if (query.equals("SELECT * FROM PEOPLE")) {
			r.setContent("Bianca, Berni, Fabian");
		}
		else if (query.equals("SELECT * FROM COMPANY")) {
			r.setContent("IBM, Microsoft, ecx.io");
		}
			
		return r;
	}

}
