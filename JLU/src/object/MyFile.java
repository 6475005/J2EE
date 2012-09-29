package object;

public class MyFile {
	private String name;
	private String dir;

	public MyFile(String name, String dir) {
		this.name = name;
		this.dir = dir;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

}
