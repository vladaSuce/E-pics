package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Photo;
import session.PhotoDao;

/**
 * Servlet implementation class SettingsController
 */
public class SettingsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private PhotoDao photoDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SettingsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idSlikeString = request.getParameter("id");
		int idSlike = Integer.parseInt(idSlikeString);
		Photo photo = photoDao.findById(idSlike);
		request.setAttribute("photo", photo);
		request.setAttribute("edit", 1);
		request.getRequestDispatcher("/addPhoto.jsp").forward(request, response);
		
	}

}
