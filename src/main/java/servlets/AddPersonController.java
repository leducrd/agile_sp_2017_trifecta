package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Strings;

import classes.AuthenticatedUser;
import classes.Person;
import classes.Vehicle;
import dao.AuthenticatedUserDao;
import dao.PersonDao;
import dao.VehicleDao;
import impl.AuthenticatedUserDaoImpl;
import impl.AuthenticatedUserException;
import impl.PersonDaoException;
import impl.PersonDaoImpl;
import impl.VehicleDaoException;
import impl.VehicleDaoImpl;

/**
 * Servlet implementation class AddPersonController
 */
@WebServlet("/AddPerson")
public class AddPersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String target = null;
	      try{
	    	  final String lastName = request.getParameter("lastName");
	    	  final String firstName = request.getParameter("firstName");
	    	  final String phone = request.getParameter("number");
	    	  final String email = request.getParameter("myEmail");
	    	  final String password = request.getParameter("password");
	    	  final String userType = request.getParameter("userType");
	    	  
	    	  final String make = request.getParameter("make");
	    	  final String model = request.getParameter("model");
	    	  final int year = Integer.parseInt(request.getParameter("year"));
	    	  final String color = request.getParameter("color");
	    	  final int maxSeats = Integer.parseInt(request.getParameter("maxSeats"));
	    	  final String smokeValue = request.getParameter("canSmoke");
	    	  
	    	  
	    	  
	    	  if(Strings.isNullOrEmpty(lastName) ||
	    			  Strings.isNullOrEmpty(firstName) ||
	    			  Strings.isNullOrEmpty(phone) ||
	    			  Strings.isNullOrEmpty(email) ||
	    			  Strings.isNullOrEmpty(password)||
	    			  Strings.isNullOrEmpty(userType)){
	    		  request.setAttribute("message", "You must complete all fields to submit the form.");
	    		  target = "error.jsp";
	    	  }else{
	    		  try{
	    		  final Person person = new Person(firstName, lastName, phone, email, password, userType);
	    		  final PersonDao personDao = new PersonDaoImpl();
	    		  
	    		  personDao.insertPerson(person);
	    		  request.setAttribute("message", "Hang Tight! You have added yourself so that drivers know you are looking for a ride!" +
	    		  		"<br>First Name: " + firstName + 
	    		  		"<br>Last Name: " + lastName + 
	    		  		"<br>Phone Number: " + phone +
	    		  		"<br>Email Address: " + email +
	    		  		"<br> User Type: " + userType);
	    		  
	    		  //TODO: If Driver check box checked, run insertVehicle method.
	    		  
	    		  if(person.getUserType().contains("d")) {
	    			  final AuthenticatedUserDao authUserDao = new AuthenticatedUserDaoImpl();
	    			  final AuthenticatedUser authUser = authUserDao.retrieveUser(person.getEmail(), person.getPassword());
	    			  
	    			  boolean canSmoke = true;
	    			  
	    			  if (smokeValue == "No") {
	    				  canSmoke = false;
	    			  }
	    			  
	    			  final Vehicle vehicle = new Vehicle(authUser.getUserID(), make, model, year, color, maxSeats, canSmoke);
	    			  
	    			  final VehicleDao vehicleDao = new VehicleDaoImpl();
	    			  
	    			  vehicleDao.insertVehicle(vehicle);
	    			  
	    			  request.setAttribute("vehicleMessage", "We've got the following car on file for you:" +
		    				  	"<br>UserID: " + vehicle.getUserID() + 
			    		  		"<br>Make: " + make + 
			    		  		"<br>Model: " + model + 
			    		  		"<br>Year: " + year +
			    		  		"<br>Color: " + color +
			    		  		"<br> Max Number of Seats: " + maxSeats +
			    		  		"<br> Can Smoke in Car?: " + smokeValue);  
	    		  }
	    		  
	    		  
	    		  target = "success.jsp";
	    	   
	    		   
	    	   }catch (NumberFormatException | AuthenticatedUserException | VehicleDaoException e) {
		   			e.printStackTrace();
		   			
		   			if (e instanceof NumberFormatException) {
		   				request.setAttribute("message", "Error: You didn't enter in all the data.");
		   			} else if (e instanceof AuthenticatedUserException) {
		   				request.setAttribute("message", "Error: We're sorry, an error occured while registering you. Please try again.");
		   			} else if (e instanceof VehicleDaoException) {
		   				request.setAttribute("message", "Error: Something went wrong with your car information. Please go back and try registering again.");
		   			}
					

					target = "error.jsp";
	    	   }
	    	  }
	    		  
	      }catch (PersonDaoException e) {
	   			e.printStackTrace();
				request.setAttribute("message", e.getMessage());
				target = "error.jsp";
	      }
	      
	      request.getRequestDispatcher(target).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
