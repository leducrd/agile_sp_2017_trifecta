package classes;

import java.io.Serializable;

public class DriverReview implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int rating;
	private String review;
	
	
	public DriverReview(){
		
	}
	
	public DriverReview(int rating, String review){
		super();
		
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


	@Override
	public String toString() {
		return "DriverReview [rating=" + rating + ", review=" + review + "]";
	}

}
