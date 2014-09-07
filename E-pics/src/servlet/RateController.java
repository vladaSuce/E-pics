package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.print.attribute.standard.PDLOverrideSupported;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import session.PhotoDao;
import session.RatingDao;
import entity.Photo;
import entity.Rating;
import entity.User;

/**
 * Servlet implementation class RateController
 */

public class RateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB
	PhotoDao photoDao;
	@EJB
	RatingDao ratingDao;
    public RateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u=(User)request.getSession().getAttribute("user");
		String id_slika=request.getParameter("id_slike");
		int idPhoto=Integer.parseInt(id_slika);
		Photo p = photoDao.findById(idPhoto);
		String rateString = request.getParameter("rate");
		int rate = Integer.parseInt(rateString);
		List<Rating> lista = ratingDao.findRatingForUserPic(u, p);
		if(lista.size()==0){
			photoDao.ratePhoto(rate, p.getId());
			Rating rateing = new Rating();
			rateing.setPhotoRating(p);
			rateing.setVote(rate);
			rateing.setUserRating(u);
			ratingDao.addRateing(rateing);
			getServletContext().getRequestDispatcher("//PictureController?id="+idPhoto).forward(request, response);
		}
		else{
			ArrayList greske =  new ArrayList<>();
			greske.add("Rejting postoji");
			request.setAttribute("greske",greske );
			getServletContext().getRequestDispatcher("//PictureController?id="+idPhoto).forward(request, response);
			
		}

	}	
}
