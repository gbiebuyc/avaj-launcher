package com.example.avaj_launcher;

public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weathertower;

	public Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		String weather = weathertower.getWeather(this.coordinates);
		int lon = this.coordinates.getLongitude();
		int lat = this.coordinates.getLatitude();
		int hei = this.coordinates.getHeight();
		System.out.printf("Helicopter#%s(%d): ", name, id);
		switch (weather) {
			case "SUN":
				this.coordinates = new Coordinates(lon+10, lat, hei+2);
				System.out.printf("There is sun.\n");
				break;
			case "RAIN":
				this.coordinates = new Coordinates(lon+5, lat, hei);
				System.out.printf("There is rain.\n");
				break;
			case "FOG":
				this.coordinates = new Coordinates(lon+1, lat, hei);
				System.out.printf("There is fog.\n");
				break;
			case "SNOW":
				this.coordinates = new Coordinates(lon, lat, hei-12);
				System.out.printf("There is snow.\n");
				break;
		}
	}

	public void registerTower(WeatherTower weathertower) {
		this.weathertower = weathertower;
		System.out.printf(
			"Tower says: Helicopter#%s(%d) registered to weather tower.\n",
			 name, id);
	}
}