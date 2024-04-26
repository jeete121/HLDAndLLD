SOLID Principles

Advantages of SOLID Principles
1. Easy to understand
2. Avoid Duplicate Code
3. Easy to maintain
4. Flexible software
5. Reduce Complexity

S--> Single Responsibility Principle
O--> Open/Closed Principle
L--> Liskov Substitution Principle
I--> Interface Segmented Principle
D--> Dependency Inversion Principles



S--> Single Responsibility Principle

A class should have only one reason to change.

Example::
$$

class Marker {
    String name;
    String color;
    int year;
    int price
    
    public Marker(String name,String color,int year,int price)
  {
     this.name=name;
     this.color=color;
     this.year=year;
     this.price=price;
  }
}

$$

class Invoice {
        private Marker marker;
        private int quantity;
       
      public Invoice(Marker marker,int quantity)
{
   this.marker=marker;
   this.quantity=quantity;
}

public int calculateTotal(){
  int price =((marker.price)*this.quantity);
   return price;
}


public void printInvoice(){
   //print the Invoice
}

public void saveToDB(){
   //Save the data into DB
}

}




class Invoice {
        private Marker marker;
        private int quantity;
       
      public Invoice(Marker marker,int quantity)
{
   this.marker=marker;
   this.quantity=quantity;
}

public int calculateTotal(){
  int price =((marker.price)*this.quantity);
   return price;
}

}


class InvoiceDao {
  Invoice invoice;
  
   public InvoiceDao(Invoice invoice) {
      this.invoice=invoice;
   } 
 
   public void saveToDB()  {
    //Save into the DB
  }
}


class InvoicePrinter {
  private Invoice invoice;


   public InvoicePrinter(Invoice invoice) {
      this.invoice=invoice;
   } 
 
   public void print()  {
    //print the invoice
   }
}
 










O--> Open/Closed Principle

Open for Extension but Closed for Modification


class InvoiceDao {
  Invoice invoice;

  public InvoiceDao(Invoice invoice) {  
       this.invoice=invoice;
  }

  public void saveToDB() {
     //Save into the DB
  }
}




class InvoiceDao {
   Invoice invoice;


  public InvoiceDao(Invoice invoice) {  
       this.invoice=invoice;
  }

  public void saveToDB() {
     //Save into the DB
  }

public void saveToFile(String filename) {
    //Save invoice in the File with the given name 
  }
}






interface InvoiceDao {

  public void save(Invoice invoice);
}



class DatabaseInvoiceDao implements InvoiceDao  {
  @Ovveride
public void  save(Invoice invoice) {
  //Save to DB
 }
}


class FileInvoiceDao implements InvoiceDao {

 @Ovveride
 public void save(Invoice invoice) {
   //Save  to file
  }
}






L--> Liskov Substitution Principle

If Class B is subtype of Class A, then we should be able to replace object of A with B without breaking the behaviour of the program

Subclass should extend the capability of parent class not narrow it down


interface Bike {

 void turnOnEngine();
 void accelerate();
}

class MotorCycle implemets Bike {
 
boolean isEngineOn;
int speed;

public void turnOnEngine() {
  //turn on the engine
  isEngineOn =true;
}

public void accelerate() {
  //increase the speed

  speed= speed +10;
  }
}



class Bicyle implemets Bike {

public void turnOnEngine() {
  throw new AssertionError("there is no engine");
}

public void accelerate() {
    //do something
  }
}





I--> Interface Segmented Principle

Intefaces should be such, that client should not implements unnecessary functions they do not need


interface RestaurantEmployee {
  void washDishes();
  void serveCustomers();
  void cookFood();
}


class Waiter implemets RestaurantEmployee {

   public void washDishes(){
     //not my job
  }

  public void serveCustomers() {
    //yes and here is my implemetation
   System.out.println("serving the customers");
 }

public void cookFood(){
  //not my job
}

}


interface WaiterInterface {
   void serveCustomers();
   void takeOrder();
}

interface ChefInterface {
  void cookFood();
  void decideMenu();
}




class Waiter implements WaiterInterface {

 public void serveCustomers() {
    System.out.println("serving the customer");  
 }

 public void takeOrder() {
  System.out.println("taking orders");
}

}







D--> Dependency Inversion Principles

Class should depend on interfaces rather than concrete classes



class MacBook {

  private final WiredKeyboard keyboard;
  private final WiredMouse mouse;

  public MacBook() {
   keyboard=new WiredKeyboard();
   mouse=new WiredMouse();
  }
}



class MacBook {

  private final Keyboard keyboard;
  private final Mouse mouse;

  public MacBook(Keyboard keyboard,Mouse mouse){
   this.keyboard=keyboard;
   this.mouse=mouse;
  }
}





Liskov Substitution Principle With Solution




public class Vehicle {

  public Integer getNumberOfWheels(){
    return 2;
  }
 
   public Boolean hasEngine(){
     return true;
  }
}



public class MotorCycle extends Vehicle{

}


public class Car extends Vehice{

@Overide 
public Integer getNumberOfWheels(){
    return 4;
 }
}


public class Bicycle extends Vehice{

@Overide 
public Boolean hasEngine(){
    return null;
 }
}



public class Main {

public static void main(String args[]){

 List<Vehicle> vehicleList=new ArrayList<>();
 vehicleList.add(new MotorCycle());
 vehicleList.add(new Car());
 vehicleList.add(new Bicycle());

 for(Vehicle vehicle: vehicleList){
   System.out.println(vehicle.hasEngine().toString());
    }
  }

}






public class Vehicle {

  public Integer getNumberOfWheels(){
    return 2;
  }
 
}


public class EngineVehicle extends Vehicle {
  public boolean hasEngine(){
   return true;
 }
}

public class MotorCycle extends EngineVehicle{

}


public class Car extends EngineVehicle{

@Ovveride 
public Integer getNumberOfWheels(){
    return 4;
 }
}


public class Bicycle extends Vehice{

}





public class Main {

public static void main(String args[]){

 List<Vehicle> vehicleList=new ArrayList<>();
 vehicleList.add(new MotorCycle());
 vehicleList.add(new Car());
 vehicleList.add(new Bicycle());

 for(Vehicle vehicle: vehicleList){
   System.out.println(vehicle.getNumberOfWheels().toString());
    }
  }

}



public class Main {

public static void main(String args[]){

 List<Vehicle> vehicleList=new ArrayList<>();
 vehicleList.add(new MotorCycle());
 vehicleList.add(new Car());
 vehicleList.add(new Bicycle());

 for(Vehicle vehicle: vehicleList){
   System.out.println(vehicle.hasEngine().toString());  //compile time
    }                                                      erro  
  }

}



public class Main {

public static void main(String args[]){

 List<EngineVehicle> vehicleList=new ArrayList<>();
 vehicleList.add(new MotorCycle());
 vehicleList.add(new Car());
 vehicleList.add(new Bicycle());   //compile time error

 for(Vehicle vehicle: vehicleList){
   System.out.println(vehicle.hasEngine().toString());
    }
  }

}


