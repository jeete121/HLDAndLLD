package builder;

import java.util.List;

public class Student {

	int rollNumber;
	int age;
	String name;
	String fatherName;
	String motherName;
	List<String> subjects;

	public Student(StudentBuilder builder) {

		this.rollNumber = builder.rollNumber;
		this.age = builder.age;
		this.name = builder.name;
		this.fatherName = builder.fatherName;
		this.motherName = builder.motherName;
		this.subjects = builder.subjects;

	}

	@Override
	public String toString() {
		return " rollNumber: " + this.rollNumber + " age: " + this.age + " name: " + this.name + " fatherName: "
				+ this.fatherName + " motherName: " + this.motherName + " subjects: " + this.subjects;
	}

}
