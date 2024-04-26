LLD of Handling NULL (Null Object Design Pattern)

Problem::


private static void printVehicleDetails(Vehicle vehicle) {

 System.out.println("Seating Capacity: " + vehicle.getSeatingCapacity());
 System.out.println("Fuel Tank Capacity: " + vehicle.getTankCapacity());

}

This method will throw NullPointerException when vehicle object is null.





Solution:: 

private static void printVehicleDetails(Vehicle vehicle) {

if(vehicle != null) {
  System.out.println("Seating Capacity: " + vehicle.getSeatingCapacity());
  System.out.println("Fuel Tank Capacity: " + vehicle.getTankCapacity());
 }
}





Here comes the NULL OJECT DESIGN PATTERN


1. A null Object replaces NULL return type.
2. No need to put IF CHECK for Checking NULL.
3. Null Object reflects do Nothing or Default behavior.




Client----------------------> Abtract Object
                               method();
                                |
                  ______________|______________
                 |                             |
                 |                             |
                 |                             |
              Real Object                    Null Object
              method();                        method();
