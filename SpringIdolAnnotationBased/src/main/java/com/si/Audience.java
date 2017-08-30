package com.si;

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
}
