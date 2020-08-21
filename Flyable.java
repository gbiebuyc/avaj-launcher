interface Flyable {
	public void updateConditions() {

	}
	public void registerTower(Weathertower Weathertower) {
		Weathertower.register(this);
	}
}