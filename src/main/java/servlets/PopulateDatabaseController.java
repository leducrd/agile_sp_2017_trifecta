package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DriverReviewDaoException;
import impl.PersonDaoException;
import impl.RideDaoException;
import impl.VehicleDaoException;
import util.DBUtility;

/**
 * Servlet implementation class PopulateDatabaseController
 */
@WebServlet("/PopulateDatabase")
public class PopulateDatabaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String target = null;
		
		try {
			
			DBUtility.createDatabase();
			request.setAttribute("message", "You were successful in populating the database.");
			
			target = "success.jsp";
		} catch (PersonDaoException | RideDaoException | DriverReviewDaoException | VehicleDaoException e) {
			
			e.printStackTrace();
			
			if (e instanceof PersonDaoException) {
				request.setAttribute("message", "Could not create people table.");
			} else if (e instanceof RideDaoException) {
				request.setAttribute("message", "Could not create rideRequest table.");
			} else if (e instanceof DriverReviewDaoException) {
				request.setAttribute("message", "Could not create driverReview table.");
			} else if (e instanceof VehicleDaoException) {
				request.setAttribute("message", "Could not create vehicle table.");
			}
			
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
