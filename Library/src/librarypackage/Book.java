package librarypackage;

public class Book {
	private int noOfCopies;
	private String name;
	private String ISBN;
	private Author author;

	public Book(String name, String ISBN, Author author) {
		this.name = name;
		this.author = author;
		this.ISBN = ISBN;

	}

	@Override
	public String toString() {
		return String.format("ISBN - %s, name - %s, author - %s", ISBN, name, author);
	}

}
