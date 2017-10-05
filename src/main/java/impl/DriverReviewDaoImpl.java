package impl;

import java.sql.Connection;
import java.sql.Statement;

import dao.DriverReviewDao;
import util.DBUtility;

public class DriverReviewDaoImpl implements DriverReviewDao {

	private static final String DROP_TABLE_DRIVERREVIEW = "DROP TABLE IF EXISTS driverReview;";
	private static final String CREATE_TABLE_DRIVERREVIEW = "CREATE TABLE driverReview (userID integer primary key autoincrement, rating int, review text);";
	private static final String SELECT_ALL_FROM_DRIVERREVIEW = "SELECT * from driverReview;";
	
	
	@Override
	public void createDatabase() throws DriverReviewDaoException {
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			statement.executeUpdate(DROP_TABLE_DRIVERREVIEW);
			statement.executeUpdate(SELECT_ALL_FROM_DRIVERREVIEW);
			
			
		} catch(ClassNotFoundException | SQLException e) {
			e.printStateTrace();
			
		throw new RideDriverDaoException("Error: Unable to populate database");
		} finally {
			DBUtility.closeConnection(connection, statement);
			
			
		}
		
		
	}
	
	
	
}
