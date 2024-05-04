package facade.scenario2;

public class OrderFacade {

	ProductDAO productDao;
	Invoice invoice;
	Payment payment;
	SendNotification notification;

	public OrderFacade() {
		productDao = new ProductDAO();
		invoice = new Invoice();
		payment = new Payment();
		notification = new SendNotification();
	}

	public void createOrder() {
		Product product = productDao.getProduct(121);
		payment.makePayment();
		invoice.generateInvoice();
		notification.sendNotification();
		// order creation successfull
	}

}