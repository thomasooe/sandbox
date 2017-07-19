package com.tom.patterns.proxy;

public class BusinessObjectProxy extends BusinessObject {
	
	private BusinessObject target;

	public BusinessObjectProxy(BusinessObject target)
	{
		this.target = target;
	}
	
	@Override
	public void sayHi() {
		System.out.println("Proxy: about to call real object");
		this.target.sayHi();
		System.out.println("Proxy: after calling real object");
	}

}
