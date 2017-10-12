package classes;

public class Vehicle {

	private int userID;
	private String make;
	private String model;
	private int year;
	private String color;
	private int maxSeats;
	private boolean canSmoke;
	
	public Vehicle() {
		
	}

	public Vehicle(int userID, String make, String model, int year, String color, int maxSeats, boolean canSmoke) {
		this.userID = userID;
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
		this.maxSeats = maxSeats;
		this.canSmoke = canSmoke;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaxSeats() {
		return maxSeats;
	}

	public void setMaxSeats(int maxSeats) {
		this.maxSeats = maxSeats;
	}

	public boolean isCanSmoke() {
		return canSmoke;
	}

	public void setCanSmoke(boolean canSmoke) {
		this.canSmoke = canSmoke;
	}
	
	
}
