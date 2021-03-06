package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.RideDao;
import impl.RideDaoException;
import impl.RideDaoImpl;

/**
 * Servlet implementation class PopulateRideDatabaseController
 */
@WebServlet("/PopulateRideDatabaseController")
public class PopulateRideDatabaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

String target = null;
		
		try {
			
			final RideDao rideDao = new RideDaoImpl();
			rideDao.createRideRequestTable();
			
			request.setAttribute("message", "You may see an error page, but really you were successful in populating the database.");
			
			target = "error.jsp";
		} catch (RideDaoException e) {
			
			e.printStackTrace();
			request.setAttribute("message", "You weren't able to populate the database.");
			
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
