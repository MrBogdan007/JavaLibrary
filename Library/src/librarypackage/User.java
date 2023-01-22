package librarypackage;

public class User {
	enum Role {
		librarian, visitor,
	}

	public Role librarian = Role.librarian;
	public Role customer = Role.visitor;

}
