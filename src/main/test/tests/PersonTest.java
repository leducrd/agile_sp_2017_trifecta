
package tests;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.Test;

import classes.Person;
import dao.PersonDao;
import impl.PersonDaoException;
import impl.PersonDaoImpl;
import util.DBUtility;

public class PersonTest {
	
	@Test
	public void personTest() {
		
			Person person1 = new Person("John","Johnson","715-555-5555","jjohnson@test.com", "password123", "r");
			assertThat(person1.getFirstName(), is("John"));
			assertThat(person1.getLastName(), is("Johnson"));
			assertThat(person1.getPhoneNumber(), is("715-555-5555"));
			assertThat(person1.getEmail(), is("jjohnson@test.com"));
			assertThat(person1.getPassword(), is("password123"));
			assertThat(person1.getUserType(), is("r"));
	}
	
	@Test
	public void retrievePeopleTest() {

		final PersonDao personDao = new PersonDaoImpl();
		
		Person person1 = new Person("John","Johnson","715-555-5555","jjohnson@test.com", "password123", "d");
		
		try {
			
			personDao.insertPerson(person1);
			
			final List<Person> people = personDao.retrievePeople();
			
			assertThat(people.isEmpty(), is(false));
		} catch (PersonDaoException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	@Test
	public void peopleTableTest() {
		
		Connection connection = null;
		Statement statement = null;
		DatabaseMetaData dbm = null;
		
		try {
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.executeUpdate("DROP TABLE IF EXISTS people;");
			statement.executeUpdate("CREATE TABLE people (userID integer primary key autoincrement, LName text, FName text, Phone text, Email text, Password text, userType text);");
			
			dbm = connection.getMetaData();
			
			ResultSet tablesList = dbm.getTables(null, null, "people", null);
			
			assertThat(tablesList.next(), is(true));
		
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtility.closeConnection(connection, statement);
		}
		
	}
}