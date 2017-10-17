package dao;

import classes.AuthenticatedUser;
import impl.AuthenticatedUserException;

public interface AuthenticatedUserDao {

	AuthenticatedUser retrieveUser(final String username, final String password) throws AuthenticatedUserException;
}
