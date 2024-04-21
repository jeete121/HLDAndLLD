package templatepattern;

public class PayToMerchant extends PaymentFlow {

	@Override
	public void validateRequest() {
		// specific validation for PayToMerchant Flow
		System.out.println("Validate logic of PayToMerchant");

	}

	@Override
	public void calculateFees() {

		// specific Fee computation logic for PayToMerchant Flow
		System.out.println("2% fees charged");

	}

	@Override
	public void debitAmount() {
		// debit the amount
		System.out.println("Debit the Amount logic of PayToMerchant");

	}

	@Override
	public void creditAmount() {

		// Credit the amount logic
		System.out.println("Credit the remaining amount");

	}

}
