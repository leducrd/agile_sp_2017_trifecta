package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.AuthenticatedUser;
import classes.Vehicle;
import dao.AuthenticatedUserDao;
import dao.VehicleDao;
import impl.AuthenticatedUserDaoImpl;
import impl.AuthenticatedUserException;
import impl.VehicleDaoException;
import impl.VehicleDaoImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String target = null;
		HttpSession session = request.getSession();
		AuthenticatedUserDao authUser = new AuthenticatedUserDaoImpl();
		VehicleDao vehicleDao = new VehicleDaoImpl();
		
		try {
			final String userName = request.getParameter("loginEmail");
			final String password = request.getParameter("password");
			
			AuthenticatedUser loggedInUser = authUser.retrieveUser(userName, password);
			
			//TODO Retrieve Vehicle
			Vehicle vehicle = vehicleDao.retrieveVehicle(loggedInUser.getUserID());
			
			session.setAttribute("people", loggedInUser);
			session.setAttribute("vehicle", vehicle);
			
			target = "userProfile.jsp";
			
		} catch (IndexOutOfBoundsException | AuthenticatedUserException | VehicleDaoException e) {

			e.printStackTrace();
			request.setAttribute("message", "Sorry. We could not find an account matching those credientials. Please register or try logging in again.");
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
