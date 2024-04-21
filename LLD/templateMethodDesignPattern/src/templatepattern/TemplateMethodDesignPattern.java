package templatepattern;

public class TemplateMethodDesignPattern {
	public static void main(String[] args) {

		PaymentFlow paymentFlow = new PayToFriend();
		paymentFlow.sendMoney();

	}

}
