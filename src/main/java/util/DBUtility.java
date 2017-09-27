package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtility {
	
	public static final int TIMEOUT = 30;
	
	public static final String DRIVER_NAME = "org.sqlite.JDBC";
	
	public static final String CONNECTION = "jdbc:sqlite:notYet.db";

	public static Connection createConnection() throws ClassNotFoundException, SQLException{
		
		Class.forName(DRIVER_NAME);
		
		return DriverManager.getConnection(CONNECTION);
	}

	public static void closeConnection(final Connection connection, final Statement statement) {
		try {
			
			if (connection != null) {
				connection.close();
			}
			
			if (statement != null) {
				statement.close();
			}	
			
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}
}