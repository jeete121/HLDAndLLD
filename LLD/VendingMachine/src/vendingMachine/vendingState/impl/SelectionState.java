package vendingMachine.vendingState.impl;

import java.util.List;

import vendingMachine.Coin;
import vendingMachine.Item;
import vendingMachine.VendingMachine;
import vendingMachine.vendingState.State;

public class SelectionState implements State {

	public SelectionState() {
		System.out.println("Currently Vending machine in Selection state");
	}

	@Override
	public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
		throw new Exception("you cannot click on insert coin button in Selection state");

	}

	@Override
	public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
		return;

	}

	@Override
	public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
		throw new Exception("you cannot insert coin in Selection state");

	}

	@Override
	public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {

		Item item = machine.getInventory().getItem(codeNumber);

		int paidByUser = 0;
		for (Coin coin : machine.getCoinList()) {
			paidByUser = paidByUser + coin.value;
		}

		if (paidByUser < item.getPrice()) {

			System.out.println("Insufficient Amount, Product you selected is of price " + item.getPrice()
					+ " but you paid " + paidByUser);

			refundFullMoney(machine);
			throw new Exception("insufficient amount");
		}
		if (paidByUser >= item.getPrice()) {
			if (paidByUser > item.getPrice()) {
				getChange(paidByUser - item.getPrice());
			}
			machine.setVendingMachineState(new DispenseState(machine, codeNumber));
		}
	}

	@Override
	public int getChange(int returnChangeMoney) throws Exception {

		System.out.println("Returned the change in the coin Dispense Tray " + returnChangeMoney);
		return returnChangeMoney;
	}

	@Override
	public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {

		throw new Exception("product can not be dispensed in Selection State");
	}

	@Override
	public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {

		System.out.println("Returned the full amount back in the Coin Dispense Tray");
		machine.setVendingMachineState(new IdleState(machine));
		return machine.getCoinList();
	}

	@Override
	public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
		throw new Exception("Inventory cannot be updated in Selection State");

	}

}
