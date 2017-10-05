package tests;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.Test;

import classes.Ride;
import dao.RideDao;
import impl.RideDaoException;
import impl.RideDaoImpl;
import util.DBUtility;



public class RideTest {

	@Test
	public void rideTest() {
		Ride ride1 = new Ride("Eaux Claires", "Eau Claire", "Ten Minutes", "Twenty Minutes", "Music");
		assertThat(ride1.getDestination(), is("Eau Claire"));
		assertThat(ride1.getEvent(), is("Eaux Claires"));
		assertThat(ride1.getLeaveTime(), is("Ten Minutes"));
		assertThat(ride1.getReason(), is("Music"));
		assertThat(ride1.getReturnTime(), is("Twenty Minutes"));
		
		}
	

	@Test
	public void retrieveRideTest() {
		
		final RideDao rideDao = new RideDaoImpl();
		try{
		final List<Ride> ride = rideDao.retrieveRide();
		assertThat(ride.isEmpty(), is(false));
		} catch (RideDaoException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void rideRequestTableTest() {
		
		Connection connection = null;
		Statement statement = null;
		DatabaseMetaData dbm = null;
		
		try {
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.executeUpdate("DROP TABLE IF EXISTS rideRequest;");
			statement.executeUpdate("CREATE TABLE rideRequest (rideID integer primary key autoincrement, userID integer, destination text, leave text, return text, event text, reason text);");
			
			dbm = connection.getMetaData();
			
			ResultSet tablesList = dbm.getTables(null, null, "rideRequest", null);
			
			assertThat(tablesList.next(), is(true));
		
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtility.closeConnection(connection, statement);
		}
		
	}

}
