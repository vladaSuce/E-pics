package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Comment;
import entity.User;
import session.CommentDao;
import session.CommentDaoBean;
import session.UserDao;
import session.UserDaoBean;

/**
 * Servlet implementation class RecentAcitvityController
 */
public class RecentAcitvityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private CommentDao commentDao;   
	@EJB
	private UserDao userDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecentAcitvityController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idString =  request.getParameter("autor_id");
		int idAutor = Integer.parseInt(idString);
		User user=userDao.findUserByID(idAutor);
		List<Comment> komentari =commentDao.lastComments(user);
		System.out.println(komentari.toString()+ " komentari");
		request.setAttribute("recentComments", komentari);
		request.getRequestDispatcher("./recentActivity.jsp").forward(request, response);
		
		
	}

}
