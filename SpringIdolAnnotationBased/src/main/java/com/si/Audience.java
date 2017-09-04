package com.si;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {
	@Pointcut("execution(* com.si.Performer.perform(..))")
	public void performance() { // Pointcut definieren
	}

	//@Before("performance()")
	public void takeSeats() { // Vor der Vorstellung
		System.out.println("AspectJ:The audience is taking their seats.");
	}

	//@Before("performance()")
	public void turnOffCellPhones() { // Vor der Vorstellung
		System.out.println("AspectJ:The audience is turning off their cellphones");
	}

	//@AfterReturning("performance()")
	public void applaud() { // Nach der Vorstellung
		System.out.println("AspectJ:CLAP CLAP CLAP CLAP CLAP");
	}

	//@AfterThrowing("performance()")
	public void demandRefund() { // Ausführung nach einer schlechten Vorstellung
		System.out.println("AspectJ:Boo! We want our money back!");
	}
	
	@Around("performance()")
	public void watchPerformance(ProceedingJoinPoint joinpoint) {
		try {
			System.out.println("AspectJ Around:The audience is taking their seats.");
			System.out.println("AspectJ Around:The audience is turning off their cellphones");
			long start = System.currentTimeMillis(); // Vor der Vorführung
			joinpoint.proceed(); // Mit Advice-Methode fortfahren
			long end = System.currentTimeMillis(); // Nach der Vorführung
			System.out.println("AspectJ Around:CLAP CLAP CLAP CLAP CLAP");
			System.out.println("AspectJ Around:The performance took " + (end - start) + " milliseconds.");
		} catch (Throwable t) {
			System.out.println("AspectJ Around:Boo! We want our money back!"); // Ausführung
		} 														// schlechten Aufführung
	}
}
