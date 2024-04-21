package vendingMachine.vendingState.impl;

import java.util.List;

import vendingMachine.Coin;
import vendingMachine.Item;
import vendingMachine.VendingMachine;
import vendingMachine.vendingState.State;

public class DispenseState implements State {

	public DispenseState(VendingMachine machine, int codeNumber) throws Exception {
		System.out.println("Currently vending machine in Dispense State");
		dispenseProduct(machine, codeNumber);
	}

	@Override
	public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
		throw new Exception("insert coin button can not clicked in Dispense State");

	}

	@Override
	public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
		throw new Exception("product selection button can not clicked in Dispense State");

	}

	@Override
	public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
		throw new Exception("coin cannot be inserted in Dispense State");

	}

	@Override
	public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
		throw new Exception("product cannot be choosen in Dispense State");

	}

	@Override
	public int getChange(int returnChangeMoney) throws Exception {
		throw new Exception("change cannot be returned in Dispense State");

	}

	@Override
	public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
		System.out.println("Product has been dispensed");
		Item item = machine.getInventory().getItem(codeNumber);
		machine.getInventory().updateSoldOutItem(codeNumber);
		machine.setVendingMachineState(new IdleState(machine));

		return item;
	}

	@Override
	public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
		throw new Exception("refund cannot be happen in Dispense State");

	}

	@Override
	public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
		throw new Exception("inventory cannot be updated in Dispense State");

	}

}
