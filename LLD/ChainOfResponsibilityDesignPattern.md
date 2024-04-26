Chain of Responsibility Design Pattern (Behavioral Design Pattern)


Application Usage::

1. ATM
2. Vending Machine
3. Design Logger


        Request                  Receiver
Sender------------> Receiver obj1------->Receiver obj2------>Receiver obj3 


In this sender sent a request to receiver's 
If first receiver does not full fill the request it will sent to the next 
receiver in the chain.
If Any receiver full fill the request then it will return the response.



                            <<Interface>>
         has-a              Handler/Processor/Receiver
Client ------------------------>Handler____| next
                               handleRequest();
                                 |
                                 |
                       __________|________________
                      |                           | 
                      |                           |
                ConcreteHandler1                ConcreteHandler2
                 handleRequest() {                handleRequest() {
                  ------                              ---
                  -------                             ---
                  }                                 }     








public abstract class LogProcessor {

	public static int INFO = 1;
	public static int DEBUG = 2;
	public static int ERROR = 3;

	LogProcessor nextLoggerProcessor;

	public LogProcessor(LogProcessor loggerProcessor) {
		this.nextLoggerProcessor = loggerProcessor;
	}

	public void log(int loglevel, String message) {
		if (nextLoggerProcessor != null) {
			nextLoggerProcessor.log(loglevel, message);
		}
	}
}



public class InfoLogProcessor extends LogProcessor {

	public InfoLogProcessor(LogProcessor loggerProcessor) {
		super(loggerProcessor);
	}

	public void log(int loglevel, String message) {

		if (loglevel == INFO) {
			System.out.println("INFO: " + message);
		} else {
			super.log(loglevel, message);
		}
	}
}





public class ErrorLogProcessor extends LogProcessor {

	public ErrorLogProcessor(LogProcessor loggerProcessor) {
		super(loggerProcessor);
	}

	public void log(int loglevel, String message) {

		if (loglevel == ERROR) {
			System.out.println("ERROR: " + message);
		} else {
			super.log(loglevel, message);
		}
	}
}




public class DebugLogProcessor extends LogProcessor {

	public DebugLogProcessor(LogProcessor loggerProcessor) {
		super(loggerProcessor);
	}

	public void log(int loglevel, String message) {

		if (loglevel == DEBUG) {
			System.out.println("DEBUG: " + message);
		} else {
			super.log(loglevel, message);
		}
	}
}




public class Main {
	public static void main(String[] args) {

		LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

		logProcessor.log(LogProcessor.ERROR, "exception happens");
		logProcessor.log(LogProcessor.DEBUG, "need to debug this");
		logProcessor.log(LogProcessor.INFO, "info");

	}

}

