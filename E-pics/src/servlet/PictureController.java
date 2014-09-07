package servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import entity.Photo;
import entity.User;
import session.AlbumDao;
import session.PhotoDao;
import session.UserDao;


public class PictureController extends HttpServlet {

	private static final long serialVersionUID = -6820366488786163882L;
	
	private static Logger log = Logger.getLogger(PictureController.class);

	@EJB
	private UserDao userDao;
	@EJB
	private AlbumDao albumDao;
	@EJB
	private PhotoDao photoDao;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ArrayList<String> listaPolova=new ArrayList<String>();
		 listaPolova.add("Male");
		 listaPolova.add("Female");
		try {
			
			String idSlike = request.getParameter("id");
			if (idSlike != null && !idSlike.equals("")) {
				int id_slike=Integer.parseInt(idSlike);
				Photo slika = photoDao.findById(id_slike);
				request.setAttribute("slika", slika);
				
				User user = userDao.findUserByPic(id_slike);
				request.setAttribute("vlasnikSlike", user);
				getServletContext().getRequestDispatcher("/picture.jsp").forward(request, response);
			} else {
				response.sendRedirect("/IndexController");
			}
			
		} catch (ServletException e) {
			log.error(e);
			throw e;
		} catch (IOException e) {
			log.error(e);
			throw e;
		}		
	}

	protected void doGet(HttpServletRequest request, 	HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}