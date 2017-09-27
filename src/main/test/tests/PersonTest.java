
package tests;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import classes.Person;

public class PersonTest {
	
	@Test
	public void personTest() {
		
			Person person1 = new Person("John","Johnson","715-555-5555","jjohnson@test.com");
			assertThat(person1.getFirstName(), is("John"));
			assertThat(person1.getLastName(), is("Johnson"));
			assertThat(person1.getPhoneNumber(), is("715-555-5555"));
			assertThat(person1.getEmail(), is("jjohnson@test.com"));
		}
}