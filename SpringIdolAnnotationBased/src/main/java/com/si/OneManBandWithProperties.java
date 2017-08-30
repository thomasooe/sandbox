package com.si;

import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

public class OneManBandWithProperties implements Performer {
	public OneManBandWithProperties() {
	}

	public void perform() throws PerformanceException {
		Enumeration e = instruments.propertyNames();

	    while (e.hasMoreElements()) {
	      String key = (String) e.nextElement();
	      System.out.println(key + " -- " + instruments.getProperty(key));
	    }
	}

	private Properties instruments;
	public void setInstruments(Properties instruments) {
	this.instruments = instruments;
	}
}