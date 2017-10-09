package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Strings;

import classes.Person;
import dao.PersonDao;
import impl.PersonDaoException;
import impl.PersonDaoImpl;

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
	    		  target = "success.jsp";
	    	   
	    		   
	    	   }catch (NumberFormatException e) {
		   			e.printStackTrace();
					request.setAttribute("message", "Error: You didn't enter in all the data.");

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
