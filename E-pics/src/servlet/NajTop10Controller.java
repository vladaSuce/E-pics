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

import session.PhotoDao;
import session.UserDao;
import entity.Photo;
import entity.User;

/**
 * Servlet implementation class NajTop10Controller
 */

public class NajTop10Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(NajTop10Controller.class);
      @EJB
      PhotoDao photoDao;
      @EJB
      UserDao userDao;
    public NajTop10Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user")==null)
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		else {
			User user=(User)request.getSession().getAttribute("user");
			
			String idAutora = request.getParameter("autor");
			if (idAutora != null && !idAutora.equals("")) {
				int id_Autora=Integer.parseInt(idAutora);
				System.out.println(id_Autora);
				User autor = userDao.findById(id_Autora);
				System.out.println(autor);
				request.getSession().setAttribute("autor", autor);
				request.getSession().setAttribute("photos", photoDao.najKSlikaAutora(autor.getId()));
				getServletContext().getRequestDispatcher("/index2.jsp?autor="+autor.getId()).forward(request, response);
			} else {
				User autor =(User) request.getSession().getAttribute("user");
				System.out.println("usao ovde ne znam zast"+autor);
				request.getSession().setAttribute("photos", photoDao.najKSlikaAutora(autor.getId()));
				
//				System.out.println(request.getSession().getAttribute("photos").toString());
//				System.out.println(request.getSession().getAttribute("albums").toString());
			}
			
//			getServletContext().getRequestDispatcher("/index2.jsp").forward(request, response);
		
	
		}
		}
}
	
