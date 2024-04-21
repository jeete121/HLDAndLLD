Template Method Design Pattern (Behavioral Design Pattern)


Pattern Category:: It's a behavioral pattern.

Why its required and When to use. 

When you want all classes to follow the specific steps to process the task 
but also Need to provide the flexibility that each class can have their own logic in that specific steps.


Payment Steps:
1. Validate Request
2. Debit Money
3. Calculate Fees
4. Credit Money

               Payment <<Interface>>
                 sendMoney();
                    |
    ________________|________________________________
   |                                                 |
   |                                                 |
  PayToFriend Flow                              PayToMerchant Flow
   
   sendMoney() {                                  sendMoney() {
         ---                                          ----
         ---                                          ----
    }                                                 -----
                                                   }




public abstract class PaymentFlow {

public abstract void validateRequest();
public abstract void calculateFees();
public abstract void debitAmount();
public abstract void creditAmount();

//this is Template method: which defines the order of steps to execute the task

public final void sendMoney() {

//Step1
  validateRequest();

//Step2
debitAmount();

//Step3
calculateFees();

//Step4
creditAmount();

}

}



public class PayToFriend extends PaymentFlow {


@Override
public void validateRequest() {
 //specific validation for PayToFriend Flow
 System.out.println("Validate logic of PayToFriend");

}

@Override
public void calculateFees() {

//specific Fee computation logic for PayToFriend Flow
System.out.println("0% fees charged");

}

@Override
public void debitAmount() {
//debit the amount
System.out.println("Debit the Amount logic of PayToFriend");


}

@Override
public void creditAmount() {

//Credit the amount logic
System.out.println("Credit the full amount");

}


}




public class PayToMerchant extends PaymentFlow {


@Override
public void validateRequest() {
 //specific validation for PayToMerchant Flow
 System.out.println("Validate logic of PayToMerchant");

}

@Override
public void calculateFees() {

//specific Fee computation logic for PayToMerchant Flow
System.out.println("2% fees charged");

}

@Override
public void debitAmount() {
//debit the amount
System.out.println("Debit the Amount logic of PayToMerchant");


}

@Override
public void creditAmount() {

//Credit the amount logic
System.out.println("Credit the remaining amount");

}


}



public class Main {

public static void main(String[] args) {

PaymentFlow paymentFlow = new PayToFriend();
paymentFlow.sendMoney();


}

}




