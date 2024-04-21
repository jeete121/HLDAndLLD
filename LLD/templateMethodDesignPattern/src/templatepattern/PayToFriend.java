package templatepattern;

public class PayToFriend extends PaymentFlow {

	@Override
	public void validateRequest() {
		// specific validation for PayToFriend Flow
		System.out.println("Validate logic of PayToFriend");

	}

	@Override
	public void calculateFees() {

		// specific Fee computation logic for PayToFriend Flow
		System.out.println("0% fees charged");

	}

	@Override
	public void debitAmount() {
		// Debit the amount
		System.out.println("Debit the Amount logic of PayToFriend");

	}

	@Override
	public void creditAmount() {

		// Credit the amount logic
		System.out.println("Credit the full amount");

	}

}
