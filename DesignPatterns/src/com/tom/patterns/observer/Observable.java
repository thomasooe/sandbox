package com.tom.patterns.observer;

import java.util.HashSet;
import java.util.Set;

public abstract class Observable {
	private Set<Observer> observers;
	
	public Observable() {
		this.observers = new HashSet<Observer>();
	}
	
	public void addObserver(Observer o) {
		this.observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		this.observers.remove(o);
	}
	
	protected void notifyDependants() {
		for (Observer observer : observers) {
			observer.update(this);
		}
	}
}
