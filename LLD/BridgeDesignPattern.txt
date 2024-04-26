Bridge Design Pattern (Structural Design Pattern)


Definition:

Bridge pattern decouples an abstraction from its implementation so that the 
two can vary independently.





  Abstraction                                         Implementor
 _________________                                  _______________________
  Implementor obj                                  
 _________________  ------------------>              implementationMethod()
  Function()                                        _______________________
                                                             |
 ____________|____                                           | 
   |         |                                               |
   |         |_______> obj.implementationMethod()            |
   |                                                         |
   |                                                         |
   |                                                     Concrete Implementor  
                                                      _________________________
 Refined Abstraction                                           
_____________________                                     implementationMethod()
  
_____________________                                  _________________________






public abstract class LivingThings {

 abstract public void breatheProcess();

}

public class Dog extends LivingThings {

@Override
public void breatheProcess() {
 //Breathe through NOSE
 //Inhale oxygen from Air
 //Exhale carbon dioxide
}
}

public class Fish extends LivingThings {

@Override
public void breatheProcess() {
 //Breathe through GILLS
 //Absorb Oxygen from Water
 //Release carbon dioxide
}
}



public class Tree extends LivingThings {

@Override
public void breatheProcess() {
 //Breathe through LEAVES
 //Inhale carbon dioxide
 //Exhale oxygen through Photosynthesis
}
}







public abstract class LivingThings {

BreatheImplementor breatheImplementor;

public LivingThings(BreatheImplementor breatheImplementor) {

  this.breatheImplementor = breatheImplementor;

}

abstract public void breatheProcess();

}



public class Dog extends LivingThings {

public Dog(BreatheImplementor breatheImplementor) {

super(breatheImplementor);

}

@Override 
public void breatheProcess() {

 breatheImplementor.breathe();

}

}



public class Fish extends LivingThings {

public Fish(BreatheImplementor breatheImplementor) {

super(breatheImplementor);

}

@Override 
public void breatheProcess() {

 breatheImplementor.breathe();

}

}



public class Tree extends LivingThings {

public Tree(BreatheImplementor breatheImplementor) {

super(breatheImplementor);

}

@Override 
public void breatheProcess() {

 breatheImplementor.breathe();

}

}



public interface BreatheImplementor {

 public void breathe();

}


public class LandBreatheImplementation implements BreatheImplementor {

@Override
 public void breathe() {
 //Breathe through NOSE
 //Inhale oxygen from Air
 //Exhale carbon dioxide

}

}


public class WaterBreatheImplementation implements BreatheImplementor {

@Override
 public void breathe() {
 //Breathe through GILLS
 //Absorb oxygen from Water
 //Release carbon dioxide

}

}


public class TreeBreatheImplementation implements BreatheImplementor {

@Override
 public void breathe() {
 //Breathe through LEAVES
 //Inhale Carbon dioxide
 //Exhale Oxygen through Photosynthesis

}

}



How Client going to invoke for example:

LivingThings fishObject = new Fish(new WaterBreatheImplementation());

fishObject.breatheProcess();