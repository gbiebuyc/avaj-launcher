package com.example.avaj_launcher;

public class WeatherProvider {
	private static WeatherProvider weatherProvider = null;
	private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider() {}

	public static WeatherProvider getProvider() {
		if (weatherProvider == null)
			weatherProvider = new WeatherProvider();
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		int i = (coordinates.getLongitude() +
			coordinates.getLatitude()) % weather.length;
		return weather[i];
	}
}