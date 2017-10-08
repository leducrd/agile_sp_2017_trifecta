package servlets;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.Person;
import dao.PersonDao;
import impl.PersonDaoException;
import impl.PersonDaoImpl;

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
		
		try {
			final String userName = request.getParameter("loginEmail");
			final String password = request.getParameter("password");
			final PersonDao personDao = new PersonDaoImpl();
			final List<Person> people = personDao.retrievePeople();
			Person loggedInUser;

			final List<Person> exactPerson = people
													.stream()
													.filter((person) -> person.getEmail().equals(userName))
													.filter((person) -> person.getPassword().equals(password))
													.collect(Collectors.toList());
			loggedInUser = exactPerson.get(0);
			
			session.setAttribute("people", loggedInUser);
			
			target = "viewAllPeople.jsp";
			
		} catch (PersonDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "Could not access database.");
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
