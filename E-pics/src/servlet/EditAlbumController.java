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
 * Servlet implementation class EditAlbumController
 */
public class EditAlbumController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @EJB
       private AlbumDao albumDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAlbumController() {
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
		String idString = request.getParameter("id");
		User user = (User)request.getSession().getAttribute("user");
		int id=Integer.parseInt(idString);
		Album album = albumDao.findById(id);
		String albumDesc = request.getParameter("albumDesc");
		String albumTitle = request.getParameter("albumTitle");
		album.setTitle(albumTitle);
		album.setDescription(albumDesc);
		String albumPublic = request.getParameter("albumPublic");
		if (albumPublic!=null)
			album.setPublicType(true);
		else
			album.setPublicType(false);
		albumDao.merge(album);
		response.sendRedirect("./IndexController?autor="+user.getId());
	}

}
