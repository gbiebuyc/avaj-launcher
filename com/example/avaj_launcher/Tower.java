package com.example.avaj_launcher;

import java.util.ArrayList;

public class Tower {
	// private Flyable[] observers;
	ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		observers.add(flyable);
	}
}