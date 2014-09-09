package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Comment;
import session.CommentDao;

/**
 * Servlet implementation class DeleteCommentController
 */

public class DeleteCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private CommentDao commentDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCommentController() {
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
		String komentarIdString = request.getParameter("komentarId");
		int komentarID = Integer.parseInt(komentarIdString);
		Comment komentar=(Comment)commentDao.findById(komentarID);
		commentDao.remove(komentar);
		String slikaIdString = request.getParameter("slikaId");
		int slikaID= Integer.parseInt(slikaIdString);
		response.sendRedirect("./PictureController?id="+slikaID);
	}

}
