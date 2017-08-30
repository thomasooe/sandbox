package com.si;

import java.util.Collection;

public class OneManBand implements Performer {
	public OneManBand() {
	}

	public void perform() throws PerformanceException {
		for (Instrument instrument : instruments) {
			instrument.play();
		}
	}

	private Collection<Instrument> instruments;
	
	public void setInstruments(Collection<Instrument> instruments) {
		this.instruments = instruments;
	}
	
	private float rdm;
	public void setRdm(float rdm) {
		this.rdm = rdm;
	}
	
	private City[] cities;
	public City[] getCities() {
		return cities;
	}

	public void setCities(City[] cities) {
		this.cities = cities;
	}
}