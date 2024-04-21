package lazy;

public class DBConnection {

	private static DBConnection conObject;

	private DBConnection() {

	}

	public static DBConnection getInstance() {

		if (conObject == null) {
			conObject = new DBConnection();
		}
		return conObject;
	}
}