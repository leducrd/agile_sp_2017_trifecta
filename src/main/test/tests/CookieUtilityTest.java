package tests;

import javax.servlet.http.Cookie;

import org.junit.Test;

import util.CookieUtility;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CookieUtilityTest {
	
	@Test
	public void getCookieValueTest() {
		
		final Cookie[] cookies = {new Cookie("testCookie", "testing@gmail.com"), new Cookie("testCookie2", "test2@gmail.com")};
		
		assertThat(CookieUtility.getCookieValue(cookies, "testCookie"), is("testing@gmail.com"));
	}

}
