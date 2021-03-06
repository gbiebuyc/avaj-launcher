package com.example.avaj_launcher;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int longitude, int latitude, int height) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = Math.min(height, 100);
	}

	public int getLongitude() {
		return this.longitude;
	}

	public int getLatitude() {
		return this.latitude;
	}

	public int getHeight() {
		return this.height;
	}
}