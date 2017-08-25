package com.si;

import java.util.Map;

public class OneManBandWithMap implements Performer {
	public OneManBandWithMap() {
	}

	public void perform() throws PerformanceException {
		for (String key : instruments.keySet()) {
			System.out.print(key + " : ");
			Instrument instrument = instruments.get(key);
			instrument.play();
		}
	}

	private Map<String, Instrument> instruments;

	public void setInstruments(Map<String, Instrument> instruments) {
		this.instruments = instruments;
	}
}