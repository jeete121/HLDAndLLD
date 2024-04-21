package vendingMachine.vendingState.impl;

import java.util.List;

import vendingMachine.Coin;
import vendingMachine.Item;
import vendingMachine.VendingMachine;
import vendingMachine.vendingState.State;

public class HasMoneyState implements State {

	public HasMoneyState() {

		System.out.println("Currently Vending machine in HasMoneyState");
	}

	@Override
	public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
		return;

	}

	@Override
	public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
		machine.setVendingMachineState(new SelectionState());

	}

	@Override
	public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
		System.out.println("Accepted the coin");
		machine.getCoinList().add(coin);

	}

	@Override
	public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
		throw new Exception("you need to first click on start product selection button");

	}

	@Override
	public int getChange(int returnChangeMoney) throws Exception {
		throw new Exception("you cannot get change in HasMoney State");
	}

	@Override
	public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
		throw new Exception("product cannot be dispensed in HasMoney State");
	}

	@Override
	public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
		System.out.println("Refund the full amount back in the coin Dispense Tray");
		machine.setVendingMachineState(new IdleState(machine));
		return machine.getCoinList();
	}

	@Override
	public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
		throw new Exception("you cannot update inventory in HasMoney State");

	}

}
