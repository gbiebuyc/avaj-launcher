package com.example.avaj_launcher;

public class AircraftFactory {
	public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
		Coordinates coordinates = new Coordinates(longitude, latitude, height);
		switch(type) {
			case "JetPlane":
				return new JetPlane(name, coordinates);
			case "Helicopter":
				return new Helicopter(name, coordinates);
			case "Baloon":
				return new Baloon(name, coordinates);
		}
		return null;
	}
}