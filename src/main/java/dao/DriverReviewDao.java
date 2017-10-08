package dao;

import java.util.List;

import classes.DriverReview;
import impl.DriverReviewDaoException;

public interface DriverReviewDao {

	void createDatabase() throws DriverReviewDaoException;
	
	void insertDriverReview(DriverReview driverReview) throws DriverReviewDaoException;
	
	List<DriverReview> retrieveDriverReview() throws DriverReviewDaoException;
}
