package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import session.UserDao;
import entity.User;
import entity.User.Gender;

/**
 * Servlet implementation class CreateUserServlet
 */

public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private UserDao userDao;
	private static Logger log = Logger.getLogger(CreateUserServlet.class);

	public CreateUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<String> greske = new ArrayList<String>();
		User user = new User();
		user.setFirstName(request.getParameter("nameSignUp"));
		user.setLastName(request.getParameter("lastName"));
		user.setEmailAdress(request.getParameter("emailSignup"));
		System.out.println(request.getParameter("password"));
		System.out.println(request.getParameter("password_confirm"));
		if(!request.getParameter("password").equals(request.getParameter("password_confirm")))
			greske.add(ResourceBundle.getBundle("messages.messages").getString("potvrdiLozinku"));
		user.setPassword(request.getParameter("password"));
		String gender=request.getParameter("gender");
		if(gender.equals(Gender.Male.toString()))
			user.setGender(Gender.Male);
		else
			user.setGender(Gender.Female);
		user.setDateOfBirth(request.getParameter("dateOfBirth"));
		if(request.getParameter("notifications")!=null)
			user.setEmailNotifications(true);
		else
			user.setEmailNotifications(false);
		
		if(userDao.findUserByEmail(user.getEmailAdress())!=null)
			greske.add(ResourceBundle.getBundle("messages.messages").getString("korisnickoImeUUpotrebi"));
		
		if(greske.size()==0){
			userDao.insertUser(user);
			request.getSession().setAttribute("user", user);
			getServletContext().getRequestDispatcher("/IndexController").forward(request, response);
			}
		else{
			request.setAttribute("greske", greske);
			doGet(request, response);
			return;
			}	
		}
	
}
