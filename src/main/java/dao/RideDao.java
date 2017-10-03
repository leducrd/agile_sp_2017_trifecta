package dao;

import java.util.List;

import classes.Ride;
import impl.RideDaoException;

public interface RideDao {
	
	void createDatabase() throws RideDaoException;
	
	void insertRide(Ride ride) throws RideDaoException;

	List<Ride> retrieveRide() throws RideDaoException;

}
