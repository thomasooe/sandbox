package com.si;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class Audience {
	public void takeSeats() { // Vor der Vorstellung
		System.out.println("The audience is taking their seats.");
	}

	public void turnOffCellPhones() { // Vor der Vorstellung
		System.out.println("The audience is turning off their cellphones");
	}

	public void applaud() { // Nach der Vorstellung
		System.out.println("CLAP CLAP CLAP CLAP CLAP");
	}

	public void demandRefund() { // Ausführung nach einer schlechten Vorstellung
		System.out.println("Boo! We want our money back!");
	}

	public void watchPerformance(ProceedingJoinPoint joinpoint) {
		try {
			System.out.println("The audience is taking their seats.");
			System.out.println("The audience is turning off their cellphones");
			long start = System.currentTimeMillis(); // Vor der Vorführung
			joinpoint.proceed(); // Mit Advice-Methode fortfahren
			long end = System.currentTimeMillis(); // Nach der Vorführung
			System.out.println("CLAP CLAP CLAP CLAP CLAP");
			System.out.println("The performance took " + (end - start) + " milliseconds.");
		} catch (Throwable t) {
			System.out.println("Boo! We want our money back!"); // Ausführung
																// nach einer
		} 														// schlechten Aufführung
	}
}
