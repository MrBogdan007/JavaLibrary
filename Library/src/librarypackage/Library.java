package librarypackage;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Library extends User {
	ArrayList<Book> books = new ArrayList();

	static ArrayList<String> ISBNal = new ArrayList();

	public static void main(String[] args) {

		Library library = new Library();
		// admin menu
		if (library.checkCredentials()) {
			Book gameOfThrones = new Book("A Game of Thrones", generateISBN(), new Author("George R. R. Martin"));
			gameOfThrones.setNoOfCopies(24);
			gameOfThrones.setGenre("novel");
			library.addNewBook(gameOfThrones);
			library.checkBooks();
			library.editBook(new Book("edited book", generateISBN(), new Author("George R. R. Martin")));
			library.checkBooks();
			library.addNewBook(new Book("A Game of Thorns", generateISBN(), new Author("George Griffin")));
			library.addNewBook(new Book("Black echo", generateISBN(), new Author("Peter Griffin")));
			library.deleteBook(0);
			library.checkBooks();

		}
		// user menu
		if (library.checkCredentials()) {
			library.addNewBook(new Book("A Game of Thrones", generateISBN(), new Author("George R. R. Martin")));
			library.checkBooks();
			library.editBook(new Book("edited book", generateISBN(), new Author("George R. R. Martin")));
			library.checkBooks();
			library.deleteBook(0);
			library.checkBooks();

		} else {
			try {
				library.borrowBook();

			} catch (Exception e) {
				return;
			}
		}

	}

	private void borrowBook() {

		System.out.println("Available books are : " + ISBNal);
		Scanner scanner = new Scanner(System.in);

		System.out.println("Type ISBN of the book you want to borrow");
		String typed = scanner.next();
		for (String number : ISBNal) {
			if (number.equals(typed)) {
				ISBNal.remove(typed);
				System.out.println("Book has been borrowed");
				System.out.println("Available books are : " + ISBNal);
			}
		}

//		books.stream().filter(book -> book.ISBN).forEach(System.out.println(book)); in javascript i can access by dot notation

	}

	private void deleteBook(int number) {
		books.remove(number);
		System.out.println("Book has been removed!");

	}

	private void editBook(Book book) {
		books.set(0, book);
		System.out.println("Book has been changed!");

	}

	private ArrayList<Book> checkBooks() {
		System.out.println(this.books);
		return this.books;

	}

	@Override
	public String toString() {
		return books + "";

	}

	private void addNewBook(Book book) {
		books.add(book);
		System.out.println("Book has been added!");

	}

	private boolean checkCredentials() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Who are your ?");
		System.out.println("options: librarian, visitor");
		String typed = scanner.next();
		String user = super.librarian.toString();
		if (typed.equals(user)) {
			System.out.println("You logged in succesfuly");
			return true;
		} else {
			System.out.println("You logged in as a visitor");
			return false;
		}

	}

	private static String generateISBN() {
		BigInteger b = new BigInteger(34, new Random());
		String s = toString(b);
		String[] arrOfStr = s.split("");
		arrOfStr[2] += "-";
		arrOfStr[4] += "-";
		arrOfStr[7] += "-";
		String ISBN = String.join("", arrOfStr);
		ISBNal.add("978-" + ISBN);
		return "978-" + ISBN;

	}

	private static String toString(BigInteger b) {
		return b.toString();
	}

}
