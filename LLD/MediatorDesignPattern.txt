Online Action System (Mediator Design Pattern)


1. The Mediator Pattern is a behavioral design pattern.
2. It encourage loose coupling by keeping objects from referring to each
   other explicitly and allows them to communicate through a mediator object.



Mediator<<interface>>        has-a       Colleague<<interface>>
+sendMessage(String msg)<--------------  sendMediator(Mediator mediator)   
  |                                      sendMessage(String msg)
  |is-a                                         |
  |                                   __________|_________________
  |                                  |                            |
ConcreteMediator                     |is-a                        |is-a
-Colleage colleague1                 |                            |
-Colleague colleague2            ConcreteColleague1          ConcreteColleague2 
+sendMessage(String msg)        sendMediator(Mediator    sendMediator(Mediator
   |           |                      medaitor)                   mediator)
   |           |                 sendMessage(String msg)   sendMessage(String msg)
   |           |_______________________|                            |
   |________________________________________________________________|



Lets use, Online Auction System Example to understand the UML.



public interface Colleague {
  void placeBid(int bidAmount);
  void receiveBidNotification(int bidAmount);
  String getName();
}


public class Bidder implements Colleague {

String name;
AuctionMediator auctionMediator;

Bidder(String name, AuctionMediator auctionMediator) {
 this.name = name;
 this.auctionMediator = auctionMediator;
 auctionMediator.addBidder(this);
}

@Override
public void placeBid(int bidAmount) {
  auctionMediator.placeBid(this,bidAmount);
}

@Override
public void receiveBidNotification(int bidAmount) {

System.out.println("Bider: " + name + " got the notification that someone has put bod of: " + bidAmount); 
 }

@Override
 public String getName() {

  return name;
}

}
 



public interface AuctionMediator {

 void addBidder(Colleague bidder);
 void placeBid(Colleague bidder, int bidAmount);
}


public class Auction implements AuctionMediator {

List<Colleague> colleagues = new ArrayList<>();

@Override
public void addBidder(Colleague bidder) {

 colleagues.add(bidder);

}

@Override
public void placeBid(Colleague bidder, int bidAmount) {

 for(Colleague colleague : colleagues) {
    if(!colleague.getName().equals(bidder.getName())) {
    colleague.receiveBidNotification(bidAmount);   
  }
  
}

}

}



public class Main {
  
 public static void main(String [] args) {
   
  AuctionMediator auctionMediatorObj = new Auction();
  Colleague bidder1 = new Bidder("A",auctionMediatorObj);
  Colleague bidder2 = new Bidder("B",auctionMediatorObj);

  bidder1.placeBid(2000);
  bidder2.placeBid(3000);
  bidder1.placeBid(3001);

 }

}