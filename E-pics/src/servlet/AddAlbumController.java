package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import entity.Album;
import entity.User;
import session.AlbumDao;




public class AddAlbumController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(AddAlbumController.class);
	@EJB
	AlbumDao albumDao;
	
	
    public AddAlbumController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String albumTitle = request.getParameter("albumTitle");
		boolean public1;
		String albumDesc = request.getParameter("albumDesc");
		if(request.getParameter("albumPublic")!=null)
			 public1=true;
		else
			public1=false;
		Album alb=new Album();
		alb.setTitle(albumTitle);
		alb.setDescription(albumDesc);
		alb.setPublic(public1);
		alb.setUser((User)request.getSession().getAttribute("user"));
		List<String> greske = new ArrayList<String>();
		
		if (albumTitle == null || albumTitle.equals("")) {
			greske.add(ResourceBundle.getBundle("messages.messages").getString("prazanNaziv"));
		}
		
		if(greske.size() == 0) {
			
			albumDao.insertAlbum(alb);
			User user=(User)request.getSession().getAttribute("user");
			request.getSession().setAttribute("albums",albumDao.findAlbumsById(user));
			
			
			
			response.sendRedirect(response.encodeRedirectURL("./IndexController"));
			
		} else {
			request.setAttribute("greske", greske);
			doGet(request, response);
			return;
		}
		
	}

}
