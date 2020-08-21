public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weathertower;

	public Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
	}

	public void registerTower(WeatherTower weathertower) {
		weathertower.register(this);
	}
}