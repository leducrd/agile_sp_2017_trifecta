package tests;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import classes.Person;
import dao.PersonDao;
import impl.PersonDaoException;
import impl.PersonDaoImpl;


public class AuthenticatedUserTest {
	
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
		List<Person> people = personDao.retrievePeople();
		Person authorizedUser = new AuthenticatedUser();
		
		final List<Person> exactPerson = people
													.stream()
													.filter((person) -> person.getEmail().equals(userName))
													.filter((person) -> person.getPassword().equals(password))
													.collect(Collectors.toList());
		
		// insert that person into an authenticated user object
		authorizedUser = exactPerson.get(0);
		
		// assert that authenticated user pulled from database is the same user that was inserted
		assertThat(authorizedUser.getFirstName(), is(testPerson.getFirstName()));
		assertThat(authorizedUser.getLastName(), is(testPerson.getLastName()));
		assertThat(authorizedUser.getPhoneNumber(), is(testPerson.getPhoneNumber()));
		assertThat(authorizedUser.getEmail(), is(testPerson.getEmail()));
		assertThat(authorizedUser.getPassword(), is(testPerson.getPassword()));
		assertThat(authorizedUser.getUserType(), is(testPerson.getUserType()));
		
	}
	
}
