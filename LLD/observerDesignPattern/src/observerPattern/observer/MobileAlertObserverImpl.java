package observerPattern.observer;

import observerPattern.observable.StocksObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver {

	String userName;
	StocksObservable observable;

	public MobileAlertObserverImpl(String userName, StocksObservable observable) {
		super();
		this.userName = userName;
		this.observable = observable;
	}

	@Override
	public void update() {
		sendSmsOnMobile(userName, "product is in stock hurry up");
	}

	private void sendSmsOnMobile(String userName, String string) {
		System.out.println("Msg sent to " + userName);
	}

}
