package bridge;

public class BridgeDesignPattern {
	public static void main(String[] args) {

		LivingThings fishObject = new Fish(new WaterBreatheImplementation());

		fishObject.breatheProcess();
	}

}
