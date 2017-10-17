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
import dao.VehicleDao;
import impl.VehicleDaoException;
import impl.VehicleDaoImpl;
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
		Vehicle car = new Vehicle(1, "Audi", "Nugget", 2008, "Pink", 4, true);
		VehicleDao vehicleDao = new VehicleDaoImpl();
		
		// query1 = current vehicle table row count
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.executeUpdate("DROP TABLE IF EXISTS vehicle;");
			statement.executeUpdate("CREATE TABLE vehicle (vehicleID integer primary key autoincrement, userID int, make text, model text, year int, color text, maxSeats int, boolean canSmoke);");
			
			// query1 = current vehicle table row count
			ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS rowCount FROM vehicle");
			resultSet.next();
			
			int countBefore = resultSet.getInt("rowCount");
			
			// insertVehicle
			vehicleDao.insertVehicle(car);
			
			// query2 = new vehicle table row count
			resultSet = statement.executeQuery("SELECT COUNT(*) AS rowCount FROM vehicle");
			resultSet.next();
			
			int countAfter = resultSet.getInt("rowCount");
			
			// assert that query2 = query1 + 1
			assertThat(countAfter, is(countBefore + 1));
			
		} catch (SQLException | ClassNotFoundException | VehicleDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtility.closeConnection(connection, statement);
		};
	}
	
	@Test
	void retrieveVehicleTest() throws VehicleDaoException {
		
		// Create vehicle
		final Vehicle vehicle1 = new Vehicle(4, "Acura", "Potato", 2013, "Pink", 4, true);
		
		// Create vehicleDao object
		final VehicleDao vehicleDao = new VehicleDaoImpl();
		
		// insert vehicle
		try {
			vehicleDao.insertVehicle(vehicle1);
		} catch (VehicleDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// retrieve vehicle
		final Vehicle vehicle2 = vehicleDao.retrieveVehicle(vehicle1.getUserID());
		
		// assert that
		assertThat(vehicle2.getUserID(), is(vehicle1.getUserID()));
		assertThat(vehicle2.getMake(), is(vehicle1.getMake()));
		assertThat(vehicle2.getMake(), is(vehicle1.getMake()));
		assertThat(vehicle2.getModel(), is(vehicle1.getModel()));
		assertThat(vehicle2.getYear(), is(vehicle1.getYear()));
		assertThat(vehicle2.getColor(), is(vehicle1.getColor()));
		assertThat(vehicle2.isCanSmoke(), is(vehicle1.isCanSmoke()));
	}

}
