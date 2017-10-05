package tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import util.DBUtility;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



public class DBUtilityTest {
	
	@Test
	public void CreateTest() {
		
	}

	@Test
	public void ConnectionTest() {
		
		Connection connection;
		try {
			connection = DBUtility.createConnection();
			assertThat(connection.isClosed(), is(false));
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void DisconnectTest() {
		Connection connection;
		Statement statement;
		
		try {
			connection = DBUtility.createConnection();
			statement = null;
			DBUtility.closeConnection(connection, statement);
			assertThat(connection.isClosed(), is(true));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}