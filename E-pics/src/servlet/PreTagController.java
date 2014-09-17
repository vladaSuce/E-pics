package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Photo;
import session.PhotoDao;

/**
 * Servlet implementation class PreTagController
 */
public class PreTagController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private PhotoDao photoDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreTagController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ida= request.getParameter("id");
		System.out.println(ida+"u pre tagucontroller");
		int id=Integer.parseInt(ida);
		Photo photo = photoDao.findById(id);
		if(photo.getTagsAllowed()){
			request.setAttribute("id", ida);
			getServletContext().setAttribute("id1",id);
			request.getRequestDispatcher("/tag.jsp").forward(request, response);
		}
		else{
			ArrayList greske = new ArrayList();
			greske.add("Tagovanje slika nije dozvoljeno od strane autora slike");
			request.setAttribute("greske", greske);
			request.getRequestDispatcher("./PictureController?id="+photo.getId()).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
