package com.tom.patterns.observer.client;

import com.tom.patterns.observer.Setup;
import com.tom.patterns.observer.Thermometer;

public class PollingThermometerClient {
	private final static long SEC_TO_RUN = 20;
	private final static long MS_BETWEEN_POLLS = 50;

	public static void main(String[] args) {
		Setup s = new Setup();
		Thermometer t = s.getThermometer();
		long count = SEC_TO_RUN * 1000 / MS_BETWEEN_POLLS;

		try {
			for (int i = 0; i < count; i++) {
				Thread.sleep(MS_BETWEEN_POLLS);
				System.out.println("Checking temperature #" + i + ": " + t.getTemperatureCelsius() + ", "
						+ t.getTemperatureKelvin() + ", " + t.getTemperatureFahrenheit());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		s.shutdown();
	}
}
