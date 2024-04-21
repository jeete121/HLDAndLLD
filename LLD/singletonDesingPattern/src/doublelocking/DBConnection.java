package doublelocking;

public class DBConnection {

	private static DBConnection conObject;

	private DBConnection() {

	}

	public static DBConnection getInstance() {

		if (conObject == null) {
			synchronized (DBConnection.class) {
				if (conObject == null) {
					conObject = new DBConnection();
				}
			}
		}
		return conObject;
	}
}