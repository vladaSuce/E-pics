package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import session.TagDao;
import entity.Comment;
import entity.Tag;

/**
 * Servlet implementation class DeleteTagController
 */

public class DeleteTagController extends HttpServlet {
	@EJB
	private TagDao tagDao;
	private static final long serialVersionUID = 1L;
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTagController() {
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
		
		String tagIDString = request.getParameter("tagId");
		int komentarID = Integer.parseInt(tagIDString);
		Tag komentar=(Tag)tagDao.findById(komentarID);
		tagDao.remove(komentar);
		String slikaIdString = request.getParameter("slikaId");
		int slikaID= Integer.parseInt(slikaIdString);
		response.sendRedirect("./PictureController?id="+slikaID);
	}

}
