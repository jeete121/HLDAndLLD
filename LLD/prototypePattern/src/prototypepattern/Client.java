package prototypepattern;

public class Client {
	public static void main(String args[]) {

		Student obj = new Student(20, 75, "Ram");
		Student cloneObj = (Student) obj.clone();

		System.out.println(cloneObj.toString());
	}
}
