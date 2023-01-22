package librarypackage;

public class Author {
	private String name;
	private String born;

	public Author(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name + "";
	}

}
