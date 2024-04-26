package bridge;

public class Fish extends LivingThings {

	public Fish(BreatheImplementor breatheImplementor) {

		super(breatheImplementor);

	}

	@Override
	public void breatheProcess() {

		breatheImplementor.breathe();

	}

}