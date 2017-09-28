package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Strings;

import classes.Person;
import classes.Ride;
import dao.PersonDao;
import impl.PersonDaoException;
import impl.PersonDaoImpl;
import impl.RideDaoException;

/**
 * Servlet implementation class RideRequestController
 */
@WebServlet("/RideRequest")
public class RideRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String target = null;
	      try{
	    	  final String event = request.getParameter("event");
	    	  final String destination = request.getParameter("destination");
	    	  final String leaveTime = request.getParameter("leave");
	    	  final String returnTime = request.getParameter("return");
	    	  final String reason = request.getParameter("reason");
	    	  
	    	  if(Strings.isNullOrEmpty(event) ||
	    			  Strings.isNullOrEmpty(destination) ||
	    			  Strings.isNullOrEmpty(leaveTime) ||
	    			  Strings.isNullOrEmpty(returnTime)||
	    			  Strings.isNullOrEmpty(reason)){
	    		  request.setAttribute("message", "You must complete all fields to submit the form.");
	    		  target = "error.jsp";
	    	  }else{
	    		  try{
	    		  final Ride ride = new Ride(event, destination, leaveTime, returnTime, reason);
	    		  final RideDao rideDao = new RideDaoImpl();
	    		  
	    		  rideDao.insertRide(ride);
	    		  request.setAttribute("message", " ");
	    		  target = "success.jsp";
	    	   
	    		   
	    	   }catch (NumberFormatException e) {
		   			e.printStackTrace();
					request.setAttribute("message", "Error: You didn't enter in all the data.");

					target = "error.jsp";
	    	   }
	    	  }
	    		  
	      }catch (RideDaoException e) {
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
