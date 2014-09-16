package servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Photo;
import session.PhotoDao;

/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
	private PhotoDao photoDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String imeAutora = request.getParameter("imeAutora");
		String prezimeAutora = request.getParameter("prezimeAutora");
		String photoTitle = request.getParameter("photoTitle");
		String photoDesc =  request.getParameter("photoDesc");
		String tagName = request.getParameter("tagName");
		String sizeOd = request.getParameter("sizeOd");
		String sizeDo = request.getParameter("sizeDo");
		boolean publicType = false;
		if(request.getSession().getAttribute("user")!=null){
			publicType=true;
		}
		List<Photo>foundPhotos = photoDao.findByUserCriteria(imeAutora,prezimeAutora,photoTitle,photoDesc,tagName,sizeOd,sizeDo,publicType);
		request.setAttribute("foundPhotos", foundPhotos);
		
		//System.out.println(foundPhotos);
		request.getRequestDispatcher("./searchResalut.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
