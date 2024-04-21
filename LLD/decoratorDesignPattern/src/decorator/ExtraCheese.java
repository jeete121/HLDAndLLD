package decorator;

public class ExtraCheese extends ToppingDecorator {

	BasePizza basePizza;

	public ExtraCheese(BasePizza basePizza) {
		super();
		this.basePizza = basePizza;
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return this.basePizza.cost() + 10;
	}

}
