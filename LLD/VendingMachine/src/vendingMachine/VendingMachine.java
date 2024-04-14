package vendingMachine;

import java.util.ArrayList;
import java.util.List;

import vendingMachine.vendingState.State;
import vendingMachine.vendingState.impl.IdleState;

public class VendingMachine {

	State vendingMachineState;
	Inventory inventory;
	List<Coin> coinList;

	public VendingMachine() {
		vendingMachineState = new IdleState();
		inventory = new Inventory(10);
		coinList = new ArrayList<>();
	}

	public State getVendingMachineState() {
		return vendingMachineState;
	}

	public void setVendingMachineState(State vendingMachineState) {
		this.vendingMachineState = vendingMachineState;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public List<Coin> getCoinList() {
		return coinList;
	}

	public void setCoinList(List<Coin> coinList) {
		this.coinList = coinList;
	}

}
