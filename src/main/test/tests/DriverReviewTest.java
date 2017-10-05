package tests;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


import java.util.List;

import org.junit.Test;

import classes.DriverReview;
import dao.DriverReviewDao;
import impl.DriverReviewDaoException;
import impl.DriverReviewDaoImpl;




public class DriverReviewTest {

	@Test
	public void driverReviewTest() {
		
		DriverReview driverReview1 = new DriverReview(4, "The driver was excellent!");
		assertThat(driverReview1.getRating(), is(4));
		assertThat(driverReview1.getReview(), is("The driver was excellent!"));
		
		
		
	}
	
	@Test 
	public void retrieveDriverReviewTest() {
		
		final DriverReviewDao driverReviewDao = new DriverReviewDaoImpl();
		try{
			final List<DriverReview> driverReview = driverReviewDao.retrieveDriverReview();
			assertThat(driverReview.isEmpty(), is(false));
		} catch (DriverReviewDaoException e){
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
}
