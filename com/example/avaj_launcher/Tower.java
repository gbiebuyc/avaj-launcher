package com.example.avaj_launcher;

import java.util.ArrayList;

public class Tower {
	ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	protected void conditionsChanged() {
		for (Flyable observer : this.observers) {
			observer.updateConditions();
		}
	}
}