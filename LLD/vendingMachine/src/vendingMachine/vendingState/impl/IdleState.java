package vendingMachine.vendingState.impl;

import java.util.ArrayList;
import java.util.List;

import vendingMachine.Coin;
import vendingMachine.Item;
import vendingMachine.VendingMachine;
import vendingMachine.vendingState.State;

public class IdleState implements State {

	public IdleState() {
		System.out.println("Currently Vending machine is in IdleState");
	}

	public IdleState(VendingMachine machine) {
		System.out.println("Currently Vending machine is in IdleState");
		machine.setCoinList(new ArrayList<>());
	}

	@Override
	public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {

		machine.setVendingMachineState(new HasMoneyState());
	}

	@Override
	public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
		throw new Exception("First you need to click on insert coin button");

	}

	@Override
	public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
		throw new Exception("you cannot insert coin in idle state");

	}

	@Override
	public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
		throw new Exception("you cannot choose product in idle state");

	}

	@Override
	public int getChange(int returnChangeMoney) throws Exception {
		throw new Exception("you cannot get change in idle state");

	}

	@Override
	public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
		throw new Exception("product cannot dispensed in idle state");

	}

	@Override
	public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
		throw new Exception("you cannot get refunded in idle state");

	}

	@Override
	public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
		machine.getInventory().addItem(item, codeNumber);

	}

}
