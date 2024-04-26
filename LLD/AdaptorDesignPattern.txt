Adaptor Design Pattern (Structural Design Pattern)


Adaptor Design Pattern is a bridge between existing interface and expected interface.


                         Bridge
Expected Interface <------------------> Existing Interface





Client-------------------->Adaptor Interface
                            request()
                              |
                              |is-a
                              |              has-a
                            ConcreteAdaptor--------->Adapte (Existing Interface)
                               request() {

                                ------
                                -----
                               }



1. PowerAdaptor And Socket

2. XML to JSON Parser




Adaptee::

public interface WeightMachine {

 //return the weight in Pound
 public double getWeightInPound();

}


public class WeightMachineForBabies implements WeightMachine {

  @Override
  public double getWeightInPound() {
   
  return 28;

}

}



Adapter::


public interface WeightMachineAdapter {

  public double getWeightInKg();

}



public class WeightMachineAdapterImpl implements WeightMachineAdapter {

WeightMachine weightMachine;

 public WeightMachineAdapterImpl(WeightMachine weightMachine) {
        this.weightMachine = weightMachine;
    }


@Override
public double getWeightInKg() {

 double weightInPound = weightMachine.getWeightInPound();

 //convert it to KGs

 double weightInKg = weightInPound*0.45;
 return weightInKg;

}

}


Client::


public class Main {

public static void main(String[] args) {

WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());

System.out.println(weightMachineAdapter.getWeightInKg());


 
}

}