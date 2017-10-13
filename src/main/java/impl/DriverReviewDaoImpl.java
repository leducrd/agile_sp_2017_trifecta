package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import classes.DriverReview;
import dao.DriverReviewDao;
import util.DBUtility;

public class DriverReviewDaoImpl implements DriverReviewDao {

	private static final String DROP_TABLE_DRIVERREVIEW = "DROP TABLE IF EXISTS driverReview;";
	private static final String CREATE_TABLE_DRIVERREVIEW = "CREATE TABLE driverReview (userID integer primary key autoincrement,driverName text, rating integer, review text);";
	private static final String SELECT_ALL_FROM_DRIVERREVIEW = "SELECT * from driverReview;";
	
	
	@Override
	public void createDriverReviewTable() throws DriverReviewDaoException {
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			statement.executeUpdate(DROP_TABLE_DRIVERREVIEW);
			statement.executeUpdate(CREATE_TABLE_DRIVERREVIEW);
			
			
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
		throw new DriverReviewDaoException("Error: Unable to populate database");
		} finally {
			DBUtility.closeConnection(connection, statement);
				
		}	
		
	}
	
	@Override
	public void insertDriverReview(DriverReview driverReview) throws DriverReviewDaoException {
		
		Connection connection = null;
		PreparedStatement insertStatement = null;
		
		try {
			
			connection = DBUtility.createConnection();
			
			final String sqlStatement = "INSERT INTO driverReview (driverName, Rating, Review) values (?,?,?);";
			
			insertStatement = connection.prepareStatement(sqlStatement);
			
			insertStatement.setString(1, driverReview.getReview());
			insertStatement.setInt(2, driverReview.getRating());
			insertStatement.setString(3, driverReview.getReview());
			
			insertStatement.setQueryTimeout(DBUtility.TIMEOUT);
			insertStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			throw new DriverReviewDaoException("Error: Unable to insert driver reviews into database.");
		} finally {
			DBUtility.closeConnection(connection, insertStatement);
		}
	}
	
	@Override
	public List<DriverReview> retrieveDriverReview() throws DriverReviewDaoException {
		
		Connection connection = null;
		Statement statement = null;
		
		final List<DriverReview> driverReview = new ArrayList<>();
	
		try {
			
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			final ResultSet resultSet = statement.executeQuery(SELECT_ALL_FROM_DRIVERREVIEW);
			
			while (resultSet.next()) {
				
				final Integer rating = resultSet.getInt("rating");
				final String review = resultSet.getString("review");
				
				driverReview.add(new DriverReview(rating, review));
				
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
			throw new DriverReviewDaoException("Error: Cannot retrieve driver reviews.");
		} finally {
			DBUtility.closeConnection(connection, statement);
		}
		
		return driverReview;
	
	}
}
	
	
