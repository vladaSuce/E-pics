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
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;


import entity.User;
import session.UserDao;

/**
 * Servlet implementation class UpdatePasswordServlet
 */

public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UserDao userDao;
	private static Logger log = Logger.getLogger(UpdatePasswordServlet.class);
	public UpdatePasswordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			if ((request.getSession().getAttribute("user")) == null) {
				response.sendRedirect(response.encodeURL("./index.jsp"));
				return;
			}
			
			getServletContext().getRequestDispatcher("/updatePassword.jsp").forward(request, response);

		} catch (ServletException e) {
			log.error(e);
			throw e;
		} catch (IOException e) {
			log.error(e);
			throw e;
		}
	}

	protected void doPost(HttpServletRequest request, 	HttpServletResponse response) throws ServletException, IOException {

		String trenutnaLozinka = request.getParameter("oldPassword");
		String novaLozinka = request.getParameter("passwordsignup");
		String potvrdjenaLozinka = request.getParameter("passwordsignup_confirm");
		
		User user = (User) request.getSession().getAttribute("user");
		List<String> greske = new ArrayList<String>();
		
		if (trenutnaLozinka == null || trenutnaLozinka.equals("")) {
			greske.add(ResourceBundle.getBundle("messages.messages").getString("praznaTrenutnaLozinka"));
		}
		
		if (novaLozinka == null || novaLozinka.equals("")) {
			greske.add(ResourceBundle.getBundle("messages.messages").getString("praznaNovaLozinka"));
		}
		
		if (potvrdjenaLozinka == null || potvrdjenaLozinka.equals("")) {
			greske.add(ResourceBundle.getBundle("messages.messages").getString("praznaPotvrdaLozinke"));
		}
		
		if(greske.size() == 0) {
			
			if(!trenutnaLozinka.equals(user.getPassword())){
				greske.add(ResourceBundle.getBundle("messages.messages").getString("nepostojecaLozinka"));
			}
			if(!novaLozinka.equals(potvrdjenaLozinka)){
				greske.add(ResourceBundle.getBundle("messages.messages").getString("novaIpotvrdjenaNepoklapanje"));
			}
			if(greske.size() == 0){
				user.setPassword(novaLozinka);
				userDao.merge(user);
				log.info("user " + user.getEmailAdress() + " je promenio lozinku.");
				response.sendRedirect(response.encodeRedirectURL("./index2.jsp"));
			}
			else{
				request.setAttribute("greske", greske);
				doGet(request, response);
				return;
			}	
		}	
		else{
			request.setAttribute("greske", greske);
			doGet(request, response);
			return;
		}	
		
	}
}

