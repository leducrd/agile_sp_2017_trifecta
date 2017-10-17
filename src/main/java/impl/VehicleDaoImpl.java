package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import classes.Vehicle;
import dao.VehicleDao;
import util.DBUtility;

public class VehicleDaoImpl implements VehicleDao {
	
	private static final String DROP_TABLE_VEHICLE = "DROP TABLE IF EXISTS vehicles;";
	//private static final String CREATE_TABLE_PEOPLE = "CREATE TABLE people (userID integer primary key autoincrement, LName text, FName text, Phone text, Email text, Password text, userType text);";	

	private static final String CREATE_TABLE_VEHICLE = "CREATE TABLE vehicles (carID integer primary key autoincrement, userID integer, make text, model text, year integer, color text, maxSeats integer, canSmoke boolean);";
	//private static final String SELECT_ALL_FROM_VEHICLE = "SELECT * from vehicle;";
	
	@Override
	public void createVehicleTable() {
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			statement.executeUpdate(DROP_TABLE_VEHICLE);
			statement.executeUpdate(CREATE_TABLE_VEHICLE);

		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
			//throw new VehicleDaoException("Error: Unable to create people table");
		} finally {
			DBUtility.closeConnection(connection, statement);
		}
		
	}
	
	@Override
	public void insertVehicle(Vehicle vehicle) throws VehicleDaoException {
		
		Connection connection = null;
		PreparedStatement insertStatement = null;
		
		try {
			connection = DBUtility.createConnection();
			
			final String sqlStatement = "INSERT INTO vehicles (userID, make, model, year, color, maxSeats, canSmoke) values (?,?,?,?,?,?,?);";
			
			insertStatement = connection.prepareStatement(sqlStatement);
			
			insertStatement.setInt(1, vehicle.getUserID());
			insertStatement.setString(2, vehicle.getMake());
			insertStatement.setString(3, vehicle.getModel());
			insertStatement.setInt(4, vehicle.getYear());
			insertStatement.setString(5, vehicle.getColor());
			insertStatement.setInt(6, vehicle.getMaxSeats());
			insertStatement.setBoolean(7, vehicle.isCanSmoke());
			
			insertStatement.setQueryTimeout(DBUtility.TIMEOUT);
			
			insertStatement.executeUpdate();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			
			throw new VehicleDaoException("Error: Unable to insert vehicle into database.");
		} finally {
			DBUtility.closeConnection(connection, insertStatement);
		}
		
	}

	

}
