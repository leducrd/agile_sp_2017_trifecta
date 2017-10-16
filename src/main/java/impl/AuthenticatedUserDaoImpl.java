package impl;

import classes.AuthenticatedUser;
import dao.AuthenticatedUserDao;

public class AuthenticatedUserDaoImpl implements AuthenticatedUserDao {

	@Override
	public AuthenticatedUser retrieveUser(String username, String password) throws AuthenticatedUserException {
		
		AuthenticatedUser authUser = new AuthenticatedUser();
		
		return authUser;
	}

}
