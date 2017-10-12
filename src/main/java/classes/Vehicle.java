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
	
	
}
