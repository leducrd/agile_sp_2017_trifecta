package tests;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import classes.Ride;
import dao.RideDao;
import impl.RideDaoException;
import impl.RideDaoImpl;



public class RideTest {

	@Test
	public void rideTest() {
		
		Ride ride1 = new Ride("Eau Claire", "Eaux Claires", "Ten Minutes", "Music", "Twenty Minutes");
		assertThat(ride1.getDestination(), is("Eau Claire"));
		assertThat(ride1.getEvent(), is("Eaux Claires"));
		assertThat(ride1.getLeaveTime(), is("Ten Minutes"));
		assertThat(ride1.getReason(), is("Music"));
		assertThat(ride1.getReturnTime(), is("Twenty Minutes"));
		
		}
	

	@Test
	public void retrieveRideTest() {
		
		final RideDao rideDao = new RideDaoImpl();
		try{
		final List<Ride> ride = rideDao.retrieveRide();
		assertThat(ride.isEmpty(), is(false));
		} catch (RideDaoException e){
			e.printStackTrace();
		}
	}

}
