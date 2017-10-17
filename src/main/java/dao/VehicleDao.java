package dao;

import classes.Vehicle;
import impl.VehicleDaoException;

public interface VehicleDao {

	void createVehicleTable() throws VehicleDaoException;
	
	void insertVehicle(Vehicle vehicle) throws VehicleDaoException;
	
	Vehicle retrieveVehicle(int authUserID) throws VehicleDaoException;
}
