package com.tom.patterns.observer;

public class Thermometer extends Observable {
	public double temperatureInKelvin = -1.0;
	private final String KELVIN_FORMAT = "%,.1fK";
	private final String CELSIUS_FORMAT = "%,.1fC";
	private final String FAHRENHEIT_FORMAT = "%,.1fF";
	
	public Thermometer() {
	}
	
	void driverValue(long value) {
		this.temperatureInKelvin = value/100.0;
		super.notifyDependants();
	}
	
	public String getTemperatureKelvin() {
		return String.format(KELVIN_FORMAT, this.temperatureInKelvin);
	}
	
	public String getTemperatureCelsius() {
		return String.format(CELSIUS_FORMAT, (this.temperatureInKelvin - 273.15));
	}
	
	public String getTemperatureFahrenheit() {
		return String.format(FAHRENHEIT_FORMAT, (this.temperatureInKelvin - 273.15));
	}
}
