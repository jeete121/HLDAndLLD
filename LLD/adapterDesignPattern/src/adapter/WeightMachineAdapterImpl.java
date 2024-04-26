package adapter;

import adaptee.WeightMachine;

public class WeightMachineAdapterImpl implements WeightMachineAdapter {

	WeightMachine weightMachine;

	public WeightMachineAdapterImpl(WeightMachine weightMachine) {
		this.weightMachine = weightMachine;
	}

	@Override
	public double getWeightInKg() {

		double weightInPound = weightMachine.getWeightInPound();

		// convert it to KGs

		double weightInKg = weightInPound * 0.45;
		return weightInKg;

	}

}
