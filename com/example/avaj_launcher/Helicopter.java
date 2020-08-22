package com.example.avaj_launcher;

public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weathertower;

	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		String weather = weathertower.getWeather(this.coordinates);
		int lon = this.coordinates.getLongitude();
		int lat = this.coordinates.getLatitude();
		int hei = this.coordinates.getHeight();
		Simulator.writer.printf("Helicopter#%s(%d): ", name, id);
		switch (weather) {
			case "SUN":
				this.coordinates = new Coordinates(lon+10, lat, hei+2);
				Simulator.writer.printf("There is sun.\n");
				break;
			case "RAIN":
				this.coordinates = new Coordinates(lon+5, lat, hei);
				Simulator.writer.printf("There is rain.\n");
				break;
			case "FOG":
				this.coordinates = new Coordinates(lon+1, lat, hei);
				Simulator.writer.printf("There is fog.\n");
				break;
			case "SNOW":
				this.coordinates = new Coordinates(lon, lat, hei-12);
				Simulator.writer.printf("There is snow.\n");
				break;
		}
		if (this.coordinates.getHeight() <= 0) {
			Simulator.writer.printf("Helicopter#%s(%d) landing.\n", name, id);
			Simulator.writer.printf("Tower says: Helicopter#%s(%d)  unregistered from weather tower.\n", name, id);
			this.weathertower.unregister(this);
		}
	}

	public void registerTower(WeatherTower weathertower) {
		this.weathertower = weathertower;
		Simulator.writer.printf(
			"Tower says: Helicopter#%s(%d) registered to weather tower.\n",
			 name, id);
	}
}