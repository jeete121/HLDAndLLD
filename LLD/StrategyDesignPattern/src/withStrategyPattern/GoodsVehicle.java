package withStrategyPattern;

import withStrategyPattern.strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle {

	public GoodsVehicle() {
		super(new NormalDriveStrategy());
	}

}
