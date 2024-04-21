package commanddesign;

//Client
public class CommandDesignPattern {
	public static void main(String[] args) {

		// AC object
		AirConditioner airConditioner = new AirConditioner();

		// remote
		MyRemoteControl remoteObj = new MyRemoteControl();

		// create the command and press the button

		remoteObj.setCommand(new TurnACOnCommand(airConditioner));
		remoteObj.pressButton();
	}
}
