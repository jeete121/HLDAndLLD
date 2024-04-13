Decorator Pattern

When ever their is a base class with some features.
If we want to add some features to that base class, there we will
use decorator pattern.


   Base Class --->  New Class
    F1             F1+F2

In this New Class is also of the same type. So that we can decorate it again.


Why you need decorator pattern?

To avoid Class explosion


                                    
  Abstract                                   Abstract
 __________________                     ______________________
|BasePizza         |   has-a           |    Topping Decorator |
|__________________|--------------     |______________________|
|                  |  is-a             |                      |
| cost();          |--------------     |                      |
|                  |                   |                      |
|__________________|                   |______________________|
 
 __________      ___________      __________________  
|Margerita |    |VegDelight |    |Extra Cheese      |
|__________|    |___________|    |__________________|
|cost(){   |    |cost(){    |    |BasePizza pizza   |
|return 100|    | return 200|    | cost(){          |
|   }      |    |     }     |    |return pizza.cost | 
|__________|    |___________|    |  +10             |
                                 |__________________|
                                  