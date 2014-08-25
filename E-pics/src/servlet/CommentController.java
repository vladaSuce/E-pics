package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Comment;
import entity.Photo;
import entity.User;
import session.CommentDao;
import session.PhotoDao;
import session.UserDao;

/**
 * Servlet implementation class CommentController
 */

public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @EJB
   UserDao userDao;
   @EJB
   PhotoDao photoDao;
   @EJB
   CommentDao commentDao;
    public CommentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_slika=request.getParameter("id_slike");
		int idPhoto=Integer.parseInt(id_slika);
		Photo p = photoDao.findById(idPhoto);
		User u=(User)request.getSession().getAttribute("user");
		Comment comm=new Comment();
		comm.setContents(request.getParameter("contents"));
		comm.setTitle(request.getParameter("title"));
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		comm.setDate(date);
		comm.setPhotoComment(p);
		comm.setUserComments(u);
		commentDao.persist(comm);
		ArrayList<Comment> commUser=null;
		if(u.getComments()==null){
			commUser=new ArrayList<Comment>();
		}
		else{
		commUser = u.getComments();
		}
		commUser.add(comm);
		u.setComments(commUser);
		userDao.merge(u);
		ArrayList<Comment> pcomm = p.getPhotoComments();
		pcomm.add(comm);
		p.setPhotoComments(pcomm);
		photoDao.merge(p);
		getServletContext().getRequestDispatcher("//PictureController?id="+idPhoto).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
