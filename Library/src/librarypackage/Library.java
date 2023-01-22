package librarypackage;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class Library {
	ArrayList<Book> books = new ArrayList();

	public static void main(String[] args) {

		Library library = new Library();
		library.addNewBook();
		library.checkBooks();

	}

	private ArrayList<Book> checkBooks() {
		System.out.println(this.books);
		return this.books;

	}

	@Override
	public String toString() {
		return books + "";
	}

	private void addNewBook() {
		Random ISBN = new Random();
		int x = ISBN.nextInt(13) + 1;
		books.add(new Book("A Game of Thrones", generateISBN(), new Author("George R. R. Martin")));
	}

	private static String generateISBN() {
		BigInteger b = new BigInteger(34, new Random());
		String s = toString(b);
		String[] arrOfStr = s.split("");
		arrOfStr[2] += "-";
		arrOfStr[4] += "-";
		arrOfStr[7] += "-";
		String ISBN = String.join("", arrOfStr);
		return "978-" + ISBN;

	}

	private static String toString(BigInteger b) {
		return b.toString();
	}

}
