package tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import util.DBUtility;

import java.sql.Connection;
import java.sql.SQLException;



public class DBUtilityTest {

	@Test
	public void ConnectionTest() {
		
		Connection connection;
		try {
			connection = DBUtility.createConnection();
			assertThat(connection, is("jdbc:sqlite:notYet.db"));
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}