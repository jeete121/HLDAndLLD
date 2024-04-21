package withStrategyPattern;

import withStrategyPattern.strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle {

	public OffRoadVehicle() {
		super(new SportsDriveStrategy());
	}

}
