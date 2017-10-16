package tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import classes.Vehicle;
import util.DBUtility;

public class VehicleTest {
	
	@Test
	public void vehicleTest() {
		Vehicle vehicle = new Vehicle(1, "Crysler", "Seabring", 1994, "Lava Red", 4, false);
		
		assertThat(vehicle.getUserID(), is(1));
		assertThat(vehicle.getMake(), is("Crysler"));
		assertThat(vehicle.getModel(), is("Seabring"));
		assertThat(vehicle.getYear(), is(1994));
		assertThat(vehicle.getColor(), is("Lava Red"));
		assertThat(vehicle.getMaxSeats(), is(4));
		assertThat(vehicle.isCanSmoke(), is(false));
	}
	
	@Test
	public void vehicleTableTest() {
		
		Connection connection = null;
		Statement statement = null;
		DatabaseMetaData dbm = null;
		
		try {
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.executeUpdate("DROP TABLE IF EXISTS vehicle;");
			statement.executeUpdate("CREATE TABLE vehicle (vehicleID integer primary key autoincrement, userID int, make text, model text, year int, color text, maxSeats int, boolean canSmoke);");
			
			dbm = connection.getMetaData();
			
			ResultSet tablesList = dbm.getTables(null, null, "vehicle", null);
			
			assertThat(tablesList.next(), is(true));
		
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtility.closeConnection(connection, statement);
		}
		
	}
	
	@Test
	public void insertVehicleTest() {
		
		// Create a new vehicle
		
		// query1 = current vehicle table row count
		
		// insertVehicle
		
		// query2 = new vehicle table row count
		
		// assert that query2 = query1 + 1
	}

}
