package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import session.PhotoDao;
import session.TagDao;
import entity.Photo;
import entity.Tag;

/**
 * Servlet implementation class TagController
 */
public class TagController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    PhotoDao photoDao;
    @EJB
    TagDao tagDao;
    
    public TagController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		//getServletContext().setAttribute(arg0, arg1);
		System.out.println(id);
		int id_slike=Integer.parseInt(id);
		Photo p=photoDao.findById(id_slike);
		Tag t= new Tag();
		t.setText(request.getParameter("tagName"));
		ArrayList<Tag> tagovi = p.getTagsPhotos();
		tagovi.add(t);
		p.setTagsPhotos(tagovi);
		ArrayList<Photo> slike = t.getPhotoTags();
		slike.add(p);
		t.setPhotoTags(slike);
		photoDao.merge(p);
		tagDao.persist(t);
		getServletContext().getRequestDispatcher("/PictureController?id="+id).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
