package synchronize;

public class DBConnection {

	private static DBConnection conObject;

	private DBConnection() {

	}

	synchronized public static DBConnection getInstance() {

		if (conObject == null) {
			conObject = new DBConnection();
		}

		return conObject;
	}

}