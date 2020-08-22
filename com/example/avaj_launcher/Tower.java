package com.example.avaj_launcher;

import java.util.ArrayList;

public class Tower {
	ArrayList<Flyable> observers = new ArrayList<Flyable>();
	ArrayList<Flyable> unregistered = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		unregistered.add(flyable);
	}

	protected void conditionsChanged() {
		this.unregistered.clear();
		for (Flyable flyable : this.observers) {
			flyable.updateConditions();
		}
		for (Flyable flyable : this.unregistered) {
			observers.remove(flyable);
		}
	}
}