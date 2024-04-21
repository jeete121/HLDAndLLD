package abstractfactory;

public class EconomicCarFactory implements AbstractFactory {

	@Override
	public Car getInstance(int price) {

		if (price <= 1000000)
			return new EconomicCar1();
		else if (price > 1000000)
			return new EconomicCar2();
		return null;
	}
}