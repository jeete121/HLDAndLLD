package commanddesign;

//Invoker
public class MyRemoteControl {

	private ICommand command;

	MyRemoteControl() {
	}

	public void setCommand(ICommand command) {

		this.command = command;
	}

	public void pressButton() {

		command.execute();
	}

}
