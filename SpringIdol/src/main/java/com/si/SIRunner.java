package com.si;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SIRunner {

	public static void main(String[] args) throws PerformanceException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		Performer performer = (Performer) ctx.getBean("hankprops");
		performer.perform();
		
		Stage stage = (Stage) ctx.getBean("theStage");
		System.out.println(stage.toString());
	}

}
