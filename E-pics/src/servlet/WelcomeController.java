package servlet;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Photo;
import session.PhotoDao;

/**
 * Servlet implementation class WelcomeController
 */
public class WelcomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @EJB
       PhotoDao photoDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 java.util.List<Photo> slike = photoDao.findAll();
			request.getSession().setAttribute("allPics", slike);
			request.getSession().setAttribute("public_photosNo_user", photoDao.findPublicNewestPics());
			getServletContext().getRequestDispatcher("/IndexController").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
