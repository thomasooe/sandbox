package com.si;

import org.springframework.stereotype.Component;

@Component
@StringedInstrument
public class Guitar implements Instrument {
	public Guitar() {
	}

	public void play() {
		System.out.println("GU GU GU");
	}
}