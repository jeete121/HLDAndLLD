package chainOfResponsibility;

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
