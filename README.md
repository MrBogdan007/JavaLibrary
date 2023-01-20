## Choose one of these two assignments

1. Library managment system:
   Design a class structure for a library management system

You should have at least 3 entities

- User
- Book
- Author
- Role (optional if you like it to be a bit more complicated)
- Category (optional)
- and other stuff (let me know if you are interested)

**You should approach it this way**

- You have a library where the User (as admin) can create books/authors (add them to the library)
- The user (as admin) can also edit, update, or delete books/authors
- The user (as a normal user) can only get the book by id or ISBN
- borrow a book

2. E-commerce, Design a class structure for an e-commerce siteb
   _the core CRUD featuers are the same as the Library (Check above)_

Add methods/logics in suitable classes for:

- Adding a product to cart
- Checking inventory for a product
- Doing payment (dummy) - optional

`A couple of examples:`

```java
// the same would be for products
Library library = new Library();
Book bookOne = new Book({
	name: "book 1",
	authorId: new Author("John", 123),
	ISBN: 1231313123123
})

library.addOneBook(book)

public class Library {
  ArrayList<Book> books = new ArrayList<>();
  public void deleteOne(Book book){
		book.remove(book)
  }
  public void addOneBook(Book book){
		book.add(book)
  }
}
```

```java
public class User {
  String name;
  String role = Role.USER
}
```
