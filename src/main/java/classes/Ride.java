package classes;

import java.io.Serializable;



public class Ride implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String event;
	private String destination;
	private String leaveTime;
	private String returnTime;
	private String reason;
	public Ride() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ride(String event, String destination, String leaveTime, String returnTime, String reason) {
		super();
		this.event = event;
		this.destination = destination;
		this.leaveTime = leaveTime;
		this.returnTime = returnTime;
		this.reason = reason;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}
	public String getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}
