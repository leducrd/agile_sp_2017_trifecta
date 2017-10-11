package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import classes.Person;
import classes.Ride;
import dao.RideDao;
import util.DBUtility;


public class RideDaoImpl implements RideDao {
	
	private static final String DROP_TABLE_RIDEREQUEST = "DROP TABLE IF EXISTS rideRequest;";
	private static final String CREATE_TABLE_RIDEREQUEST = "CREATE TABLE rideRequest (rideID integer primary key autoincrement, userID integer, destination text, leave text, return text, event text, reason text);";
	private static final String SELECT_ALL_FROM_RIDEREQUEST = "SELECT * from rideRequest;";
	
	public void createRideRequestTable() throws RideDaoException {
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);

			statement.executeUpdate(DROP_TABLE_RIDEREQUEST);
			statement.executeUpdate(CREATE_TABLE_RIDEREQUEST);
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
			throw new RideDaoException("Error: Unable to create RideRequest Table.");
		} finally {
			DBUtility.closeConnection(connection, statement);
		}
	}

	@Override
	public void insertRide(Ride ride) throws RideDaoException {
		
		Connection connection = null;
		PreparedStatement insertStatement = null;
		
		try {
			
			connection = DBUtility.createConnection();
			
			final String sqlStatement = "INSERT INTO rideRequest (event, destination, leave, return, reason) values (?,?,?,?,?);";
			
			insertStatement = connection.prepareStatement(sqlStatement);
			
			insertStatement.setString(1, ride.getEvent());
			insertStatement.setString(2, ride.getDestination());
			insertStatement.setString(3, ride.getLeaveTime());
			insertStatement.setString(4, ride.getReturnTime());
			insertStatement.setString(5, ride.getReason());
			
			
			insertStatement.setQueryTimeout(DBUtility.TIMEOUT);
			
			insertStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			
			throw new RideDaoException("Error: Unable to insert person into database.");
		} finally {
			DBUtility.closeConnection(connection, insertStatement);
		}
		
	}

	@Override
	public List<Ride> retrieveRide() throws RideDaoException{
		Connection connection = null;
		Statement statement = null;
		
		final List<Ride> rides = new ArrayList<>();
		
		try {
			
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			final ResultSet resultSet = statement.executeQuery(SELECT_ALL_FROM_RIDEREQUEST);
			
			while (resultSet.next()) {
				
				final String event = resultSet.getString("event");
				final String destination = resultSet.getString("destination");
				final String leave = resultSet.getString("leave");
				final String returnTime = resultSet.getString("return");
				final String reason = resultSet.getString("reason");
				
				rides.add(new Ride(event, destination, leave, returnTime, reason));
			}
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
			
			throw new RideDaoException("Error: Cannot retrieve Rides.");
		} finally {
			DBUtility.closeConnection(connection, statement);
		}
		
		return rides;
		
	}
}