Memento Design Pattern:


It is also known as Snapshot Design Pattern.

Pattern Category: It's a behavioral pattern.

Why its required and When to use:

Provides and ability to revert an object to a previous state, i.e. UNDO capability
And
It does not expose the object internal implemetaion.


Major Components in MEMENTO PATTERN

1. Originator
2. Memento
3. Caretaker


Originator:
 1. It represents the object, for which state nedd to be saved and restored.
 2. Expose Methods to save and restore its state using Memento object.

Memento:
 1. It represents an Object which holds the state of the Originator.

Caretaker:
 1. Manages the list of States(i.e list of Memento)


       has-a
     ___________   Creator
    |             _____________________
    |            -List<Memento> history
    |            +addMemento(Memento obj)
    |            +Memento undo()
    |            _______________________
    |            
    |
    |
    |
    |                                     has-a
    |                            ________________     Originator
    |             has-a         |                  ____________________________
 Memento        __________      |                    -State state
___________________       |     |                    +Memento createMemento()
-State state              |     | 
+setState(State state)    |     |                    +restoreMemento(Memento m)
+State getState()         |     |                  _____________________________
___________________       |     |   
                          |     |
                              State
                           ________________
                           String xyz;
                           int someProperty;
                           _________________





Caretaker::

public class ConfigurationCareTaker {
 
List<ConfigurationMemento> history  = new ArrayList<>();

public void addMemento(ConfigurationMemento memento) {

 history.add(memento);
}

public ConfigurationMemento undo() {

 if(!history.isEmpty())  {
  int lastMementoIndex = history.size() - 1;
  //get the last memento from the list
  ConfigurationMemento lastMemento = history.get(lastMementoIndex);
  
  //remove the last memento from the list now
  history.remove(lastMementoIndex);
  return lastMemento;

 }
return null;
 
}

}




Memento::

public class ConfigurationMemento {

 int height;
 int width;

 public ConfigurationMemento(int height,int width) {

  this.height = height;
  this.width = width;
 }

 public int getHeight() {
   
   return height;
 }

 public int getWidth() {
   return width;
 }


}



Originator::

public class ConfigurationOriginator {

 int height;
 int width;
 ConfigurationOriginator(int height,int width) {
  this.height = height;
  this.width = width;  
 }

 public void setHeight(int height) {
  this.height = height;
 }

 public void setWidth(int width) {
  this.width = width;
 }

  public ConfigurationMemento createMemento() {
    return new ConfigurationMemento(this.height,this.width);
  }

   public void restoreMemento(ConfigurationMemento mementoToBeRestored) {
   
    this.height = mementoToBeRestored.height;
    this.width = mementoToBeRestored.width;
   
 }

}




public class Client {

 public static void main(String[] args) {

 ConfigurationCareTaker careTakerObject = new ConfigurationCareTaker();
 
 //initiate State of the originator
 ConfigurationOriginator originatorObject = new ConfigurationOriginator(5,10);

 //save it
 ConfigurationMemento snapshot1 = originatorObject.createMemento();

 //add it to history
 careTakerObject.addMemento(snapshot1);

 //originator changing to new state
 originatorObject.setHeight(7);
 originatorObject.setWidth(12);

 //save it
ConfigurationMemento snapshot2 = originatorObject.createMemento();

 //add it to history
 careTakerObject.addMemento(snapshot2);


 //originator changing to new state
 originatorObject.setHeight(9);
 originatorObject.setWidth(14);

  //UNDO
  ConfigurationMemento restoreStateMementoObj = careTakerObject.undo();
  
   originatorObject.restoreMemento(restoreStateMementoObj);

  System.out.println("height: " + originatorObject.height + " width: " +
                   originatorObject.width); 
  
 }
 
}


