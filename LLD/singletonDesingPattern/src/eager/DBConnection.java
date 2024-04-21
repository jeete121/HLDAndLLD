package eager;

public class DBConnection {

	private static DBConnection conObject = new DBConnection();

	private DBConnection() {

	}

	public static DBConnection getInstance() {
		return conObject;
	}

}