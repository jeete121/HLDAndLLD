package abstractfactory;

public class AbstractFactoryDesignPattern {

	public static void main(String args[]) {

		AbstractFactoryProducer abstractFactoryProducerObj = new AbstractFactoryProducer();

		AbstractFactory abstractFactoryObj = abstractFactoryProducerObj.getFactoryInstance("Premium");

		Car carObj = abstractFactoryObj.getInstance(5000000);

		System.out.println(carObj.getToSpeed());
	}

}