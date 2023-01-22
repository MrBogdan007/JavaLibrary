package librarypackage;

public class User {
	enum Role {
		LIBRARIAN, VISITOR,
	}

	private Role librarian = Role.LIBRARIAN;
	private Role customer = Role.VISITOR;

	public User(Role librarian, Role customer) {
		this.librarian = librarian;
		this.customer = customer;
	}

}
