package servlets;

	import java.io.IOException;
	import java.util.List;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	import com.google.common.base.Strings;

import classes.DriverReview;
import dao.DriverReviewDao;
import impl.DriverReviewDaoException;
import impl.DriverReviewDaoImpl;

	/**
	 * Servlet implementation class RideRequestController
	 */
	@WebServlet("/RideRequest")
	public class DriverReviewController extends HttpServlet {
		private static final long serialVersionUID = 1L;

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String target = null;
			HttpSession session = request.getSession();
		      try{
		    	  final String driverName = request.getParameter("driverName");
		    	  final int rating = Integer.parseInt(request.getParameter("rating"));
		    	  final String review = request.getParameter("review");
		    	 
		    	  
		    	  if(Strings.isNullOrEmpty(driverName) ||
		    			  rating == 0 ||
		    			  Strings.isNullOrEmpty(review)) {
		    		  request.setAttribute("message", "You must complete all fields to submit the form.");
		    		  target = "error.jsp";
		    	  }else{
		    		  try{
		    		  final DriverReview driverReview = new DriverReview(driverName, rating, review);
		    		  final DriverReviewDao driverReviewDao = new DriverReviewDaoImpl();
		    		  
		    		  DriverReviewDao.insertDriverReview(driverReview);
		    		  final List<DriverReview> driverReviews = driverReviewDao.retrieveDriverReview();
		  			
		  			
		  			session.setAttribute("driverReviews", driverReviews);
		  			
		  			target = "success.jsp";
		    	   
		    		   
		    	   }catch (NumberFormatException e) {
			   			e.printStackTrace();
						request.setAttribute("message", "Error: You didn't enter in all the data.");

						target = "error.jsp";
		    	   }
		    	  }
		    		  
		      }catch (DriverReviewDaoException e) {
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


