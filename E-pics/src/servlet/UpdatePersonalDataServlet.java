package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;
import entity.User.Gender;
import session.UserDao;

/**
 * Servlet implementation class UpdatePersonalDataServlet
 */
public class UpdatePersonalDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     @EJB  
	protected UserDao userDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePersonalDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("user")==null){
			response.sendRedirect("./IndexController");
		}
		User usr=(User) session.getAttribute("user");
		usr.setDateOfBirth(request.getParameter("dateOfBirth"));
		usr.setFirstName(request.getParameter("firstName"));
		usr.setLastName(request.getParameter("lastName"));
		usr.setEmailAdress(request.getParameter("newEmail"));
		String gender=request.getParameter("gender");
		if(gender.equals(Gender.Male.toString()))
			usr.setGender(Gender.Male);
		else
			usr.setGender(Gender.Female);
		
		
		String parm = request.getParameter("notifications");
		System.out.println(parm);
		if(request.getParameter("notifications")!=null)
			usr.setEmailNotifications(true);
		else
			usr.setEmailNotifications(false);
		
		
		
		userDao.updateUser(usr);
		getServletContext().getRequestDispatcher("/IndexController").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
