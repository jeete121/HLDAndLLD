package chainOfResponsibility;

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
