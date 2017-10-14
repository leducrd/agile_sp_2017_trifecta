package impl;

import dao.VehicleDao;

public class VehicleDaoImpl implements VehicleDao {
	
	private static final String DROP_TABLE_VEHICLE = "DROP TABLE IF EXISTS vehicles;";
	private static final String CREATE_TABLE_VEHICLE = "CREATE TABLE vehicle (carID integer primary key autoincrement, userID integer, make text, model text, year integer, color text, maxSeats integer, canSmoke boolean);";
	private static final String SELECT_ALL_FROM_VEHICLE = "SELECT * from vehicle;";
	
	@Override
	public void createVehicleTable() {
		
		
	}
	
	

}
