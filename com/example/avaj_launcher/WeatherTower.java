package com.example.avaj_launcher;

public class WeatherTower extends Tower {
	public String getWeather(Coordinates coordinates) {
		WeatherProvider provider = WeatherProvider.getProvider();
		return provider.getCurrentWeather(coordinates);
	}

	void changeWeather() {
		this.conditionsChanged();
	}
}