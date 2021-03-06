package com.si;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SIRunner {

	public static void main(String[] args) throws PerformanceException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		Properties settings = (Properties) ctx.getBean("settings");
				
	    Map<String, String> env = (Map<String, String>) ctx.getBean("systemEnvironment");
	    Map<String, String> props = (Map<String, String>) ctx.getBean("systemProperties");
		
		Performer performer = (Performer) ctx.getBean("hank");
		performer.perform();
		
		Stage stage = (Stage) ctx.getBean("theStage");
		System.out.println(stage.toString());
		
		
	}

}
