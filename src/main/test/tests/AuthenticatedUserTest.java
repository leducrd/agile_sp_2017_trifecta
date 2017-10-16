package tests;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import classes.AuthenticatedUser;
import classes.Person;
import dao.PersonDao;
import impl.PersonDaoException;
import impl.PersonDaoImpl;


public class AuthenticatedUserTest {
	
	@Test
	public void authenticatedUserTest() {
		AuthenticatedUser authUser = new AuthenticatedUser(1, "George", "Baliey", "123-456-7890", "george.bailey@gmail.com", "pass123", "d");
		assertThat(authUser.getUserID(), is(1));
		assertThat(authUser.getFirstName(), is("George"));
		assertThat(authUser.getLastName(), is("Baliey"));
		assertThat(authUser.getPhoneNumber(), is("123-456-7890"));
		assertThat(authUser.getEmail(), is("george.bailey@gmail.com"));
		assertThat(authUser.getPassword(), is("pass123"));
		assertThat(authUser.getUserType(), is("d"));
	}
	
	@Test
	public void retrieveAuthUserTest() throws PersonDaoException {
		// create person
		Person testPerson = new Person("Bob","Dole","715-555-5555","bobTest@test.com", "password123", "r");
		
		// Create PersonDao object
		PersonDao personDao = new PersonDaoImpl();
		
		// insert Person
		personDao.insertPerson(testPerson);
		
		// retrieve person from table based on email and password
		final String userName = testPerson.getEmail();
		final String password = testPerson.getPassword();
		AuthenticatedUserDao authUserDao = new AuthenticatedUserDaoImpl();
		
		AuthenticatedUser authUser = authUserDao.retrieveUser(userName, password);
		
		
		// assert that authenticated user pulled from database is the same user that was inserted
		assertThat(authUser.getFirstName(), is(testPerson.getFirstName()));
		assertThat(authUser.getLastName(), is(testPerson.getLastName()));
		assertThat(authUser.getPhoneNumber(), is(testPerson.getPhoneNumber()));
		assertThat(authUser.getEmail(), is(testPerson.getEmail()));
		assertThat(authUser.getPassword(), is(testPerson.getPassword()));
		assertThat(authUser.getUserType(), is(testPerson.getUserType()));
		
	}
	
}
