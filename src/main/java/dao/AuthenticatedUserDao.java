package dao;

import classes.AuthenticatedUser;
import impl.AuthenticatedUserException;

public interface AuthenticatedUserDao {

	AuthenticatedUser retrieveUser() throws AuthenticatedUserException;
}
