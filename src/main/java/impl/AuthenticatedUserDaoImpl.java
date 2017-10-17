package impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import classes.AuthenticatedUser;
import dao.AuthenticatedUserDao;
import util.DBUtility;

public class AuthenticatedUserDaoImpl implements AuthenticatedUserDao {

	private static final String SELECT_ALL_FROM_PERSON = "SELECT * from people;";
	
	@Override
	public AuthenticatedUser retrieveUser(String enteredUsername, String enteredPassword) throws AuthenticatedUserException {
		
		AuthenticatedUser authUser = new AuthenticatedUser();
		final List<AuthenticatedUser> users = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			final ResultSet resultSet = statement.executeQuery(SELECT_ALL_FROM_PERSON);
			
			while (resultSet.next()) {
				
				final Integer userID = resultSet.getInt("userID");
				final String lastName = resultSet.getString("LName");
				final String firstName = resultSet.getString("FName");
				final String phone = resultSet.getString("Phone");
				final String email = resultSet.getString("Email");
				final String password = resultSet.getString("Password");
				final String userType = resultSet.getString("userType");
				
				users.add(new AuthenticatedUser(userID, firstName, lastName, phone, email, password, userType));
			}
			
			authUser = users.stream()
							.filter((user) -> user.getEmail().equals(enteredUsername))
							.filter((user) -> user.getPassword().equals(enteredPassword))
							.collect(Collectors.toList()).get(0);
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return authUser;
	}

}
