package librarypackage;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Library extends User {
	ArrayList<Book> books = new ArrayList();

	public static void main(String[] args) {

		Library library = new Library();
		// librarian menu
		if (library.checkCredentials()) {
			Book gameOfThrones = new Book("A Game of Thrones", generateISBN(), new Author("George R. R. Martin"));
			gameOfThrones.setNoOfCopies(24);
			gameOfThrones.setGenre("novel");
			library.addNewBook(gameOfThrones);

			library.addNewBook(new Book("A Game of Thorns", generateISBN(), new Author("George Griffin")));
			library.addNewBook(new Book("Black echo", generateISBN(), new Author("Peter Griffin")));

			library.editBook(2);
			library.checkBooks();
			library.deleteBook(0);

			library.checkBooks();

		}

		if (library.checkCredentials()) {
			library.addNewBook(new Book("A Game of Thrones", generateISBN(), new Author("George R. R. Martin")));
			library.checkBooks();
			library.editBook(0);
			library.checkBooks();
			library.deleteBook(0);
			library.checkBooks();

		}
		// visitor menu
		else {
			try {
				library.borrowBook();

			} catch (Exception e) {
				return;
			}
		}

	}

	private void borrowBook() {
		System.out.println("Available books are :");
		for (Book book : books) {

			System.out.printf("ISBN: %s", book.getISBN() + ", ");

		}

		Scanner scanner = new Scanner(System.in);

		System.out.println("\nType ISBN of the book you want to borrow");
		String typed = scanner.next();

		for (Book book : books) {
			if (book.getISBN().equals(typed)) {
				System.out.printf("Book has been borrowed with ISBN - %s", book.getISBN());
				books.remove(book);
			}
		}

	}

	private void deleteBook(int number) {
		books.remove(number);
		System.out.println("Book has been removed!");

	}

	private void editBook(int position) {

		String ISBN = books.get(position).getISBN();
		books.set(position, new Book("element changed with same isbn", ISBN, new Author("George R. R. Martin")));
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
//		books.stream().filter(bookk -> bookk.getISBN().equals(bookk.getISBN()))
//				.forEach(bookk -> System.out.println("FOR EACH" + bookk));

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
		return "978-" + ISBN;

	}

	private static String toString(BigInteger b) {
		return b.toString();
	}

}
