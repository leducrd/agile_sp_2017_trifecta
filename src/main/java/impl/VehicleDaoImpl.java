package impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import dao.VehicleDao;
import util.DBUtility;

public class VehicleDaoImpl implements VehicleDao {
	
	private static final String DROP_TABLE_VEHICLE = "DROP TABLE IF EXISTS vehicles;";
	private static final String CREATE_TABLE_VEHICLE = "CREATE TABLE vehicle (carID integer primary key autoincrement, userID integer, make text, model text, year integer, color text, maxSeats integer, canSmoke boolean);";
	private static final String SELECT_ALL_FROM_VEHICLE = "SELECT * from vehicle;";
	
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
			
			//throw new PersonDaoException("Error: Unable to create people table");
		} finally {
			DBUtility.closeConnection(connection, statement);
		}
		
	}
	
	

}
