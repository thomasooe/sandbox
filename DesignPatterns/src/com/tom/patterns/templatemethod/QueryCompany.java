package com.tom.patterns.templatemethod;

public class QueryCompany extends AbstractQuery {

	@Override
	protected String getQueryString() {
		return "SELECT * FROM COMPANY";
	}

}
