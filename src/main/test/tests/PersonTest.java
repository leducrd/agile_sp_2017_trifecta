
package tests;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import classes.Person;
import dao.PersonDao;
import impl.PersonDaoException;
import impl.PersonDaoImpl;

public class PersonTest {
	
	@Test
	public void personTest() {
		
			Person person1 = new Person("John","Johnson","715-555-5555","jjohnson@test.com", "password123");
			assertThat(person1.getFirstName(), is("John"));
			assertThat(person1.getLastName(), is("Johnson"));
			assertThat(person1.getPhoneNumber(), is("715-555-5555"));
			assertThat(person1.getEmail(), is("jjohnson@test.com"));
			assertThat(person1.getEmail(), is("password123"));
	}
	
	@Test
	public void retrievePeopleTest() {

		final PersonDao personDao = new PersonDaoImpl();
		
		try {
			final List<Person> people = personDao.retrievePeople();
			
			assertThat(people.isEmpty(), is(false));
		} catch (PersonDaoException e) {
			
			e.printStackTrace();
			
		}
		
	}
}