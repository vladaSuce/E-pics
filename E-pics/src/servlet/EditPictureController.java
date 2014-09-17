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
 * Servlet implementation class EditPictureController
 */
public class EditPictureController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private PhotoDao photoDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPictureController() {
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
		int id = Integer.parseInt(idString);
		Photo photo = photoDao.findById(id);
		String photoPublic = request.getParameter("photoPublic");
		String comments_allowed = request.getParameter("comments_allowed");
		String notes_allowed = request.getParameter("notes_allowed");
		String tags_allowed = request.getParameter("tags_allowed");
		String photoTitle = request.getParameter("photoTitle");
		String photoDecs = request.getParameter("photoDecs");
		photo.setTitle(photoTitle);
		photo.setDescription(photoDecs);
		if (photoPublic!=null)
			photo.setPublicType(true);
		else
			photo.setPublicType(false);
		if(comments_allowed!=null)
			photo.setCommentsAllowed(true);
		else 
			photo.setCommentsAllowed(false);
		if(notes_allowed!=null)
			photo.setNotesAllowed(true);
		else
			photo.setNotesAllowed(false);
		if(tags_allowed!=null)
			photo.setTagsAllowed(true);
		else
			photo.setTagsAllowed(false);
		photoDao.merge(photo);
		response.sendRedirect("./PictureController?id="+photo.getId());
	}

}
