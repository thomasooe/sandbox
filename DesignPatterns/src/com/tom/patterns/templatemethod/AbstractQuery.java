package com.tom.patterns.templatemethod;

public abstract class AbstractQuery implements Query {

	@Override
	public Result execute() {
		Connection c = new Connection();
		Result r = c.executeQuery(this.getQueryString());
		return r;
	}
	
	abstract protected String getQueryString();
}
