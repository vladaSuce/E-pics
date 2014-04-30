
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

import session.AlbumDao;
import session.UserDao;
import entity.User;

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = -7345471861052209628L;

	private static Logger log = Logger.getLogger(LoginController.class);

	@EJB
	private UserDao userDao;
	@EJB
	private AlbumDao albumDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		try {

			String emailAdress = request.getParameter("korisnickoIme");
			String password = request.getParameter("lozinka");
			
			List<String> greske = new ArrayList<String>();
			

			if (emailAdress == null || emailAdress.equals("")) {
				greske.add(ResourceBundle.getBundle("messages.messages").getString("emptyEmail"));
			}

			if (password == null || password.equals("")) {
				greske.add(ResourceBundle.getBundle("messages.messages").getString("emptyPassword"));
			}
			
			if(greske.size() == 0) {
				User user = userDao.findUser(emailAdress, password);
	
				if (user != null) {
					HttpSession session = request.getSession(true);
					session.setAttribute("user", user);
					session.setAttribute("albums",albumDao.findAlbumsById(user));
					log.info("User " + emailAdress + " logged in.");
					session.setAttribute("autor", user);
					response.sendRedirect(response.encodeRedirectURL("./IndexController"));
				}
				else {
					greske.add(ResourceBundle.getBundle("messages.messages").getString("badLogIn"));
					request.setAttribute("greske", greske);
					getServletContext().getRequestDispatcher("/IndexController").forward(request, response);
					return;
				}
			} else {
				request.setAttribute("greske", greske);
				getServletContext().getRequestDispatcher("/IndexController").forward(request, response);
				return;
			}

		} catch (ServletException e) {
			log.error(e);
			throw e;
		} catch (IOException e) {
			log.error(e);
			throw e;
		}
	}
}
