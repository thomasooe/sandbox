package com.tom.patterns.proxy;

public class BusinessObjectImplementation extends BusinessObject {

	/* (non-Javadoc)
	 * @see com.tom.patterns.proxy.BusinessObject#sayHi()
	 */
	@Override
	public void sayHi() {
		System.out.println("Hello World");
	}
}
