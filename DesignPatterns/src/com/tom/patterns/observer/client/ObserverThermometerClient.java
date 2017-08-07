package com.tom.patterns.observer.client;

import com.tom.patterns.observer.Observable;
import com.tom.patterns.observer.Observer;
import com.tom.patterns.observer.Setup;
import com.tom.patterns.observer.Thermometer;

public class ObserverThermometerClient implements Observer{
	
	public static void main(String[] args) {
		Setup s = new Setup();
		ObserverThermometerClient client = new ObserverThermometerClient();
		s.getThermometer().addObserver(client);
		try {
			Thread.sleep(20000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		s.shutdown();
	}

	@Override
	public void update(Observable o) {
		Thermometer t = (Thermometer) o;
		System.out.println("Checking temperature " + t.getTemperatureCelsius() + ", "
				+ t.getTemperatureKelvin() + ", " + t.getTemperatureFahrenheit());
		
	}
}
