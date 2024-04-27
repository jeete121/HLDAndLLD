package problemstatement;

public class File {

	String filename;

	public File(String name) {
		this.filename = name;
	}

	public void ls() {
		System.out.println("file name " + filename);
	}

}