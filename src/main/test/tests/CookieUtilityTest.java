package tests;

import javax.servlet.http.Cookie;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CookieUtilityTest {
	
	@Test
	public void getCookieValueTest() {
		
		final Cookie cookie = new Cookie("testCookie", "testing@gmail.com");
		
		assertThat(CookieUtility.getCookieValue(), is("testing@gmail.com"));
	}

}
