package commandundo;

public class TurnACOffCommand implements ICommand {

	private AirConditioner ac;

	TurnACOffCommand(AirConditioner ac) {
		this.ac = ac;
	}

	@Override
	public void execute() {

		ac.turnOffAC();

	}

	@Override
	public void undo() {

		ac.turnOnAC();

	}

}