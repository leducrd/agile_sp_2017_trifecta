package classes;

import java.io.Serializable;

public class DriverReview implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String driverName;
	private int rating;
	private String review;
	
	
	public DriverReview(){
		
	}
	
	public DriverReview(String driverName, int rating, String review){
		super();
		
		this.driverName = driverName;
		this.rating = rating;
		this.review = review;
		
		
		}
	
	
	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public String getReview() {
		return review;
	}


	public void setReview(String review) {
		this.review = review;
	}


	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	@Override
	public String toString() {
		return "DriverReview [driverName=" + driverName + ", rating=" + rating + ", review=" + review + "]";
	}
	

}
