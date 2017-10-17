package classes;

public class AuthenticatedUser extends Person{

	private static final long serialVersionUID = 1L;

	private int userID;
	
	public AuthenticatedUser() {
		
	}
	
	public AuthenticatedUser(int userID, String firstName, String lastName, String phoneNumber, String email, String password, String userType) {
		super(firstName, lastName, phoneNumber, email, password, userType);
		this.userID = userID;
	}

	public int getUserID() {
		return userID;
	}
	
	
}
