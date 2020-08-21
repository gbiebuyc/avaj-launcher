public class Simulator {
	public static void main(String [] args) {
		WeatherTower weatherTower = new WeatherTower();
		AircraftFactory aircraftFactory = new AircraftFactory();

		String type = "Helicopter";
		String name = "test";
		Flyable x = aircraftFactory.newAircraft(type, name, 1, 2, 3);
		x.registerTower(weatherTower);
	}
}