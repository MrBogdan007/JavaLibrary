package librarypackage;

public class Book {

	private String name;
	private String ISBN;
	private Author author;
	// not mandatory properties
	private int noOfCopies;
	private String genre;

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Book(String name, String ISBN, Author author) {
		this.name = name;
		this.author = author;
		this.ISBN = ISBN;

	}

	@Override
	public String toString() {
		return String.format("ISBN - %s, name - %s, author - %s, genre - %s, number of copies - %d", ISBN, name, author,
				genre, noOfCopies);
	}

	public String getISBN() {
		return ISBN;
	}

	public int getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

}
