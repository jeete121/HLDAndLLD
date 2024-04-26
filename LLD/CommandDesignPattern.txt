Command Design Pattern (Behavioral Design Pattern)


Pattern Category: It's a behavioral pattern.


Lets take the use-case of Remote control which can control various home appliaces and with that lets undestand the problem, then we will go with this pattern.


public class AirConditioner {

boolean isOn;
int temperature;

public void turnOnAC() {

 isOn = true;
 System.out.println("AC is ON");

}

public void turnOffAC() {

  isOn = false;
  System.out.println("AC is OFF");

}

public void setTemperature(int temp) {
  
  this.temperature = temp;
  System.out.println("Temperature change to: " + temperature);
}

}



public class Main {
 
 public static void main(String[] args) {

  AirConditioner ac = new AirConditioner();
  ac.turnOnAC();
  ac.setTemperature(24);
  ac.turnOffAC();

 }

}



Problem with above implementation:

1. Lack of Abstraction: Today, process of turning of AC is simple, but if there are more steps, client has to aware all of that, which is not good.

2. Undo/Redo Functionality: What if I wanr to implement the undo/redo capability. How it will be handled.

3. Difficulty in Code Maintenace: What if in future, we have to support more commands for more devices example Bulb.




public class AirConditioner {

boolean isOn;
int temperature;

public void turnOnAC() {

 isOn = true;
 System.out.println("AC is ON");

}

public void turnOffAC() {

  isOn = false;
  System.out.println("AC is OFF");

}

public void setTemperature(int temp) {
  
  this.temperature = temp;
  System.out.println("Temperature change to: " + temperature);
}

}


public class Bulb {

boolean isOn;

public void turnOnBulb() {

 isOn = true;
 System.out.println("Bulb is ON");

}

public void turnOffBulb() {

  isOn = false;
  System.out.println("Bulb is OFF");

}


}


public class Main {
 
 public static void main(String[] args) {

  AirConditioner ac = new AirConditioner();
  ac.turnOnAC();
  ac.setTemperature(24);
  ac.turnOffAC();

  Bulb bulbObj = new Bulb();
  bulbObj.turnOnBulb();
  bulbObj.turnOffBulb(); 

 }

}



How COMMAND DESIGN PATTERN Solves it?

It separates the logic of:

1. Receiver
2. Invoker
3. Command


                (Remote)  has-a
  Client------> Invoker --------------> Command --------> Receiver




Receiver::

public class AirConditioner {

boolean isOn;
int temperature;

public void turnOnAC() {

 isOn = true;
 System.out.println("AC is ON");

}

public void turnOffAC() {

  isOn = false;
  System.out.println("AC is OFF");

}

public void setTemperature(int temp) {
  
  this.temperature = temp;
  System.out.println("Temperature change to: " + temperature);
}

}



Invoker::

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


Command::

public interface ICommand {
 
public void execute();

}



public class TurnACOnCommand implements ICommand {

private AirConditioner ac;
TurnACOnCommand(AirConditioner ac) {
  this.ac = ac;
}

@Override
public void execute() { 
 
ac.turnOnAC();

}

}

public class TurnACOffCommand implements ICommand {

private AirConditioner ac;
TurnACOffCommand(AirConditioner ac) {
  this.ac = ac;
}

@Override
public void execute() { 
 
ac.turnOffAC();

}

}



Client:: 


public class Main {

public static void main(String[] args) {

//AC object
AirConditioner airConditioner = new AirConditioner();

//remote
MyRemoteControl remoteObj  = new MyRemoteControl();

//create the command and press the button

remoteObj.setCommand(new TurnACOnCommand(airConditioner));
remoteObj.pressButton();
}

}








Implemente Copy Paste System with Undo


Receiver::

public class AirConditioner {

boolean isOn;
int temperature;

public void turnOnAC() {

 isOn = true;
 System.out.println("AC is ON");

}

public void turnOffAC() {

  isOn = false;
  System.out.println("AC is OFF");

}

public void setTemperature(int temp) {
  
  this.temperature = temp;
  System.out.println("Temperature change to: " + temperature);
}

}



Invoker::

public class MyRemoteControl {

Stack<ICommand> acCommandHistory = new Stack<>();

private ICommand command;

MyRemoteControl() {
}

public void setCommand(ICommand command) {

  this.command = command;
}

public void pressButton() {

 command.execute();
 acCommandHistory.add(command);
}

public void undo() {

if(!acCommandHistory.isEmpty()) {
 ICommand lastCommand = acCommandHistory.pop();
 lastCommand.undo();

}

}

}


Command::

public interface ICommand {
 
public void execute();
public void undo();

}



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



Client:: 


public class Main {

public static void main(String[] args) {

//AC object
AirConditioner airConditioner = new AirConditioner();

//remote
MyRemoteControl remoteObj  = new MyRemoteControl();

//create the command and press the button

remoteObj.setCommand(new TurnACOnCommand(airConditioner));
remoteObj.pressButton();

// undo the last operation
remoteObj.undo();
}

}

