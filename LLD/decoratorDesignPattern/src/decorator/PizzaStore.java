package decorator;

public class PizzaStore {
	public static void main(String[] args) {

		BasePizza pizza = new Mushroom(new ExtraCheese(new Margherita()));
		System.out.println(pizza.cost());
	}

}
