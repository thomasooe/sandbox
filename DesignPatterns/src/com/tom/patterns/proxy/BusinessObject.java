package com.tom.patterns.proxy;

abstract public class BusinessObject {

	public abstract void sayHi();
	public static BusinessObject create()
	{
		return new BusinessObjectProxy(new BusinessObjectImplementation());
	}
}