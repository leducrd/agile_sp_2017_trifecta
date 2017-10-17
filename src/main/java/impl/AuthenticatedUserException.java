package impl;

public class AuthenticatedUserException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public AuthenticatedUserException(final String message) {
		super(message);
	}

}
