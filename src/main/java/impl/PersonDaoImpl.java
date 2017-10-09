package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import classes.Person;
import dao.PersonDao;
import util.DBUtility;

public class PersonDaoImpl implements PersonDao {
	private static final String DROP_TABLE_PEOPLE = "DROP TABLE IF EXISTS people;";
	private static final String CREATE_TABLE_PEOPLE = "CREATE TABLE people (userID integer primary key autoincrement, LName text, FName text, Phone text, Email text, Password text, userType text);";	
	private static final String SELECT_ALL_FROM_PERSON = "SELECT * from people;";
	
	@Override
	public void createPeopleTable() throws PersonDaoException {
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			statement.executeUpdate(DROP_TABLE_PEOPLE);
			statement.executeUpdate(CREATE_TABLE_PEOPLE);

		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
			throw new PersonDaoException("Error: Unable to create people table");
		} finally {
			DBUtility.closeConnection(connection, statement);
		}
	}

	@Override
	public void insertPerson(Person person) throws PersonDaoException {
		
		Connection connection = null;
		PreparedStatement insertStatement = null;
		
		try {
			
			connection = DBUtility.createConnection();
			
			final String sqlStatement = "INSERT INTO people (LName, FName, Phone, Email, Password) values (?,?,?,?,?);";
			
			insertStatement = connection.prepareStatement(sqlStatement);
			
			insertStatement.setString(1, person.getLastName());
			insertStatement.setString(2, person.getFirstName());
			insertStatement.setString(3, person.getPhoneNumber());
			insertStatement.setString(4, person.getEmail());
			insertStatement.setString(5, person.getPassword());
			
			insertStatement.setQueryTimeout(DBUtility.TIMEOUT);
			
			insertStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			
			throw new PersonDaoException("Error: Unable to insert person into database.");
		} finally {
			DBUtility.closeConnection(connection, insertStatement);
		}
		
	}
	
	@Override
	public List<Person> retrievePeople() throws PersonDaoException {
		
		Connection connection = null;
		Statement statement = null;
		
		final List<Person> people = new ArrayList<>();
		
		try {
			
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			final ResultSet resultSet = statement.executeQuery(SELECT_ALL_FROM_PERSON);
			
			while (resultSet.next()) {
				
				//final Integer userID = resultSet.getInt("userID");
				final String lastName = resultSet.getString("LName");
				final String firstName = resultSet.getString("FName");
				final String phone = resultSet.getString("Phone");
				final String email = resultSet.getString("Email");
				final String password = resultSet.getString("Password");
				final String userType = resultSet.getString("userType");
				
				people.add(new Person(firstName, lastName, phone, email, password, userType));
			}
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
			
			throw new PersonDaoException("Error: Cannot retrieve people.");
		} finally {
			DBUtility.closeConnection(connection, statement);
		}
		
		return people;
	}
}