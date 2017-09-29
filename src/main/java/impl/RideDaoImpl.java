package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import classes.Ride;
import dao.PersonDao;
import util.DBUtility;

/**
 * Servlet implementation class RideDaoImp
 */
@WebServlet("/RideDaoImp")
public class RideDaoImpl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String DROP_TABLE_RIDEREQUEST = "DROP TABLE IF EXISTS rideRequest;";
	private static final String CREATE_TABLE_RIDEREQUEST = "CREATE TABLE rideRequest (rideID integer primary key autoincrement, userID integer, destination text, leave text, return text, event text, reason text);";

	
	public void createDatabase() throws RideDaoException {
		
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
			
			throw new RideDaoException("Error: Unable to populate database");
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
			
			final String sqlStatement = "";
			
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
}