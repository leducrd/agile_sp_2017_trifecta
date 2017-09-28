package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import classes.Person;
import dao.PersonDao;
import util.DBUtility;

public class PersonDaoImpl implements PersonDao {
	private static final String DROP_TABLE_PEOPLE = "DROP TABLE IF EXISTS people;";
	private static final String CREATE_TABLE_PEOPLE = "CREATE TABLE people (userID integer primary key autoincrement, LName text, FName text, Phone text, Email text, Password text);";	

	private static final String DROP_TABLE_RIDEREQUEST = "DROP TABLE IF EXISTS rideRequest;";
	private static final String CREATE_TABLE_RIDEREQUEST = "CREATE TABLE rideRequest (rideID integer primary key autoincrement, userID integer, destination text, leave text, return text, event text, reason text);";

	
	@Override
	public void createDatabase() throws PersonDaoException {
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			statement.executeUpdate(DROP_TABLE_PEOPLE);
			statement.executeUpdate(CREATE_TABLE_PEOPLE);
			statement.executeUpdate(DROP_TABLE_RIDEREQUEST);
			statement.executeUpdate(CREATE_TABLE_RIDEREQUEST);
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
			throw new PersonDaoException("Error: Unable to populate database");
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
			
			final String sqlStatement = "INSERT INTO people (LName, FName, Phone, Email) values (?,?,?,?);";
			
			insertStatement = connection.prepareStatement(sqlStatement);
			
			insertStatement.setString(1, person.getFirstName());
			insertStatement.setString(2, person.getLastName());
			insertStatement.setString(3, person.getPhoneNumber());
			insertStatement.setString(4, person.getEmail());
			
			
			insertStatement.setQueryTimeout(DBUtility.TIMEOUT);
			
			insertStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			
			throw new PersonDaoException("Error: Unable to insert person into database.");
		} finally {
			DBUtility.closeConnection(connection, insertStatement);
		}
		
	}
}