Strategy Design Pattern


 ______________                      ________________________
|Sporty Vehicle|   is-a             | Base Class             |
| _____________|  -------------->   |________________________|   
|drive()       |                    |  drive()               |
|{             |                    |   {                    |
| //special    |                    |    //normal capability |
| //capabilty  |                    |   }                    |
|              |                    | display(){             |           
|}             |                    |       }                |
|______________|                    |________________________|                

Child                                 

 _________________    is-a              
|Passenger Vehicle|   ------------------> 
|_________________|
|drive()          |
| {               |
|  //same as      |
|  //base class   |
| }               |         
|_________________|

 ________________  is-a
|OffRoad Vehicle | ------>
| _______________|
|drive()         |
|{               |
|  //special     |
|   //capability |
| (same as of    |
| Sporty vehicle)|
|}               |
|________________|

In this we are duplicating the code at child levels.
To solve this problem we can use Strategy Design Pattern


                        
                is-a                 has-a
Sporty Vehicle    ----->Vehicle  | ------>  DriveStrategy (Interface)
Passenger Vehicle ----->         
OffRoad Vehicle   ----->




 ______________           ___________________         _______________
|Sporty Vehicle|   is-a  | Vehicle           |       |DriveStrategy  |
| _____________|  -----> |___________________| has-a |_______________|
|              |         |                   |-----> |               |
|              |         |DriveStrategy obj; |       | drive();      |
|              |         |Vehicle(           |       |               |
|              |         |DriveStrategy obj) |       |               |
|              |         |{this.obj=obj;}    |       |               |
|              |         | drive(){obj.drive |       |_______________|
|______________|         |___________________|                

Child                                 
                                                      _____________
 _________________    is-a                           |Normal Drive |
|Passenger Vehicle|   ----->                         |_____________|
|_________________|                                  |drive()      |
|                 |                                  | { //normal} |
|                 |                                  |_____________|
|                 |
|                 |                                   _____________  
|                 |                                  |Special      |
|_________________|                                  |Drive        |
                                                     |_____________|
 ________________   is-a                             |             |
|OffRoad Vehicle | ------>                           |drive()      |
|________________|                                   |{//special } |
|                |                                   |_____________|
|                |
|                |
|                |
|________________|