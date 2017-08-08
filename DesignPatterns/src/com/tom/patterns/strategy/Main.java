package com.tom.patterns.strategy;

import java.util.Random;

import com.tom.patterns.strategy.Printer.QueueStrategy;

public class Main {
	private static final int NUMBER_OF_JOBS = 5;
	private static final int MAX_JOB_DURATION_IN_SEC = 2;

	public static void main(String[] args) {
		Random r = new Random();
		System.out.println("Starting experiment");
		User u[] = { new User("John Doe"), new User("Jane Doe"), new User("Susan Doe") };

		Printer p = new Printer(QueueStrategy.JOB_PRIORITY);
		p.start();
		for (int i = 0; i < NUMBER_OF_JOBS; i++) {
			p.print(new Job(u[r.nextInt(u.length)], "Content set (something random=" + r.nextInt() + ")", r.nextInt(100)));
		}
		try {
			Thread.sleep(NUMBER_OF_JOBS * MAX_JOB_DURATION_IN_SEC * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		p.shutdownPrinter();
		System.out.println("Ending experiment");
	}

}
