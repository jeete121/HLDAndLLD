package commandundo;

public class TurnACOnCommand implements ICommand {

	private AirConditioner ac;

	TurnACOnCommand(AirConditioner ac) {
		this.ac = ac;
	}

	@Override
	public void execute() {

		ac.turnOnAC();

	}

	@Override
	public void undo() {

		ac.turnOffAC();

	}

}