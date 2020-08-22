package com.example.avaj_launcher;

public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weathertower;

	public JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		String weather = weathertower.getWeather(this.coordinates);
		int lon = this.coordinates.getLongitude();
		int lat = this.coordinates.getLatitude();
		int hei = this.coordinates.getHeight();
		System.out.printf("JetPlane#%s(%d): ", name, id);
		switch (weather) {
			case "SUN":
				this.coordinates = new Coordinates(lon, lat+10, hei+2);
				System.out.printf("There is sun.\n");
				break;
			case "RAIN":
				this.coordinates = new Coordinates(lon, lat+5, hei);
				System.out.printf("There is rain.\n");
				break;
			case "FOG":
				this.coordinates = new Coordinates(lon, lat+1, hei);
				System.out.printf("There is fog.\n");
				break;
			case "SNOW":
				this.coordinates = new Coordinates(lon, lat, hei-7);
				System.out.printf("There is snow.\n");
				break;
		}
		if (this.coordinates.getHeight() <= 0) {
			System.out.printf("JetPlane#%s(%d) landing.\n", name, id);
			System.out.printf("Tower says: JetPlane#%s(%d)  unregistered from weather tower.\n", name, id);
			this.weathertower.unregister(this);
		}
	}

	public void registerTower(WeatherTower weathertower) {
		this.weathertower = weathertower;
		System.out.printf(
			"Tower says: JetPlane#%s(%d) registered to weather tower.\n",
			 name, id);
	}
}