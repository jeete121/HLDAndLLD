package doublelocking;

public class DoubleLockingInitialization {
	public static void main(String[] args) {

		DBConnection connObject = DBConnection.getInstance();

		DBConnection connObject2 = DBConnection.getInstance();
		System.out.println(connObject.equals(connObject2));
	}

}
