package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Album;
import session.AlbumDao;

/**
 * Servlet implementation class PreEditAlbumController
 */

public class PreEditAlbumController extends HttpServlet {
	@EJB
	private AlbumDao albumDao;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreEditAlbumController() {
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
		String alubmIdString=request.getParameter("id");
		int albumID=Integer.parseInt(alubmIdString);
		Album album = (Album)albumDao.findById(albumID);
		request.setAttribute("tempAlbum", album);
		response.sendRedirect("./album.jsp?edit=1");
	}

}
