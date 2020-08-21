public class AircraftFactory {
	public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
		Coordinates coordinates = new Coordinates(longitude, latitude, height);
		if (type.equals("Helicopter"))
			return new Helicopter(name, coordinates);
		return null;
	}
}