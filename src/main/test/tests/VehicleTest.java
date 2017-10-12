package tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

import classes.Vehicle;

public class VehicleTest {
	
	@Test
	public void vehicleTest() {
		Vehicle vehicle = new Vehicle(1, "Crysler", "Seabring", 1994, "Lava Red", 4, false);
		
		assertThat(vehicle.getUserID(), is(1));
		assertThat(vehicle.getMake(), is("Crysler"));
		assertThat(vehicle.getModel(), is("Seabring"));
		assertThat(vehicle.getYear(), is(1994));
		assertThat(vehicle.getColor(), is("Lava Red"));
		assertThat(vehicle.getMaxSeats(), is(4));
		assertThat(vehicle.isCanSmoke(), is(false));
	}

}
