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
		// Iterate on a copy because items may be deleted.
		for (Flyable flyable : new ArrayList<Flyable>(observers)) {
			flyable.updateConditions();
		}
	}
}