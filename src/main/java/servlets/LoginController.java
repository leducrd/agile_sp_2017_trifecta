package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		boolean isUser = false;
		final String userName = request.getParameter("loginEmail");
		final String password = request.getParameter("password");
		
		final PersonDao personDao = new PersonDaoImpl();
		List<Person> people;
		
		try {
			people = personDao.retrievePeople();
			
			for (Person person : people) {
				
				if (person.getEmail() == userName) {
					
					isUser = true;
					break;
				}
				
			}
			
			if (isUser) {
				request.setAttribute("message", "You have successfully logged in.");
				
				target = "success.jsp";
			} else {
				
				request.setAttribute("message", "Sorry, either your username or password are incorrect");
				request.setAttribute("people", people);
				target = "viewAllPeople.jsp";
				
			}
			
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
