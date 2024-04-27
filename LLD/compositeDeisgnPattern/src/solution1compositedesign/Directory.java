package solution1compositedesign;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {

	String directoryName;
	List<FileSystem> fileSystemList;

	public Directory(String name) {
		this.directoryName = name;
		fileSystemList = new ArrayList<>();
	}

	public void add(FileSystem filesystemObj) {
		fileSystemList.add(filesystemObj);
	}

	public void ls() {

		System.out.println("Directory name " + directoryName);
		for (FileSystem fileSystemObj : fileSystemList) {
			fileSystemObj.ls();
		}

	}

}