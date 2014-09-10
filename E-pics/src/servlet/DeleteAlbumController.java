package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Album;
import entity.User;
import session.AlbumDao;

/**
 * Servlet implementation class DeleteAlbumController
 */
public class DeleteAlbumController extends HttpServlet {
	@EJB
	private AlbumDao albumDao;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAlbumController() {
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
		String idAlbumString = request.getParameter("id");
		int albumID= Integer.parseInt(idAlbumString);
		System.out.println(albumID);
		Album album = (Album)albumDao.findById(albumID);
		System.out.println(album.toString());
		albumDao.remove(album);
		User user = (User)request.getSession().getAttribute("user");
		response.sendRedirect("./IndexController?autor="+user.getId());
		
	}

}
