package observerPattern.observer;

import observerPattern.observable.StocksObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver {

	String emailId;
	StocksObservable observable;

	public EmailAlertObserverImpl(String emailId, StocksObservable observable) {
		super();
		this.emailId = emailId;
		this.observable = observable;
	}

	@Override
	public void update() {
		sendMail(emailId, "product is in stock hurry up");
	}

	private void sendMail(String emailId, String msg) {

		System.out.println("Mail sent to " + emailId);
	}

}
