package com.tom.patterns.templatemethod;

public class QueryPeople extends AbstractQuery {

	@Override
	protected String getQueryString() {
		return "SELECT * FROM PEOPLE";
	}

}
