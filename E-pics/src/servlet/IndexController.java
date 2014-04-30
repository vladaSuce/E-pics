package servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.dsig.keyinfo.PGPData;

import org.apache.log4j.Logger;

import entity.Photo;
import entity.User;
import session.AlbumDao;
import session.PhotoDao;
import session.UserDao;


public class IndexController extends HttpServlet {

	private static final long serialVersionUID = -6820366488786163882L;
	
	private static Logger log = Logger.getLogger(IndexController.class);

	@EJB
	private UserDao userDao;
	@EJB
	private AlbumDao albumDao;
	@EJB
	private PhotoDao photoDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		if(request.getSession().getAttribute("user")==null){
				if(request.getParameter("autor")!="" && request.getParameter("autor")!=null){
					int usrID = Integer.parseInt(request.getParameter("autor"));
					request.getSession().setAttribute("public_photosNo_user", photoDao.findPublicPhotoByUserID(usrID));
				}
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
			else {
				User user=(User)request.getSession().getAttribute("user");
				
				String idAutora = request.getParameter("autor");
				if (idAutora != null && !idAutora.equals("")) {
					int id_Autora=Integer.parseInt(idAutora);
					System.out.println(id_Autora+"dobar autor");
					User autor = userDao.findById(id_Autora);
					request.getSession().setAttribute("autor", autor);
					request.getSession().setAttribute("photos", photoDao.findPicsByUser(autor));
					getServletContext().getRequestDispatcher("/index2.jsp").forward(request, response);
				}
					else{
					User	autor=userDao.findById(user.getId());
					request.getSession().setAttribute("photos", photoDao.findPicsByUser(autor));
					getServletContext().getRequestDispatcher("/index2.jsp").forward(request, response);
					}
					
					//getServletContext().getRequestDispatcher("/IndexController?autor="+autor.getId()).forward(request, response);
			
					//response.sendRedirect("IndexController");
//					System.out.println(request.getSession().getAttribute("photos").toString());
//					System.out.println(request.getSession().getAttribute("albums").toString());
				
				
				//getServletContext().getRequestDispatcher("/index2.jsp").forward(request, response);
			}
		} catch (ServletException e) {
			log.error(e);
			throw e;
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}