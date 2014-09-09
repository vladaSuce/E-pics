package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Photo;
import entity.User;
import session.PhotoDao;

/**
 * Servlet implementation class DeletePictureController
 */

public class DeletePictureController extends HttpServlet {
	@EJB
	private PhotoDao picDao;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePictureController() {
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
		String slikaIdString = request.getParameter("slikaId");
		int slikaID= Integer.parseInt(slikaIdString);
		Photo picture=picDao.findById(slikaID);
		picDao.remove(picture);
		User user = (User)request.getSession().getAttribute("user");
		response.sendRedirect("./IndexController?autor="+user.getId());
	}

}
