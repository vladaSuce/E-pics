package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import session.UserDao;
import entity.User;

/**
 * Servlet implementation class CheckRateController
 */
public class CheckRateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @EJB
   UserDao userDao;
    public CheckRateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user")!=null){
			User user=(User)request.getSession().getAttribute("user");
			String id_pic=request.getParameter("id");
			System.out.println(id_pic);
			int idPic=Integer.parseInt(id_pic);
			User autor=userDao.findUserByPic(idPic);
			if(autor.getId()==user.getId()){
				
				response.sendRedirect("PictureController?id="+id_pic);
			}
			else{
			request.setAttribute("id", id_pic);	
			request.getRequestDispatcher("/ratePhoto.jsp").forward(request, response);
			}
		}else
			response.sendRedirect("IndexController");
		
		
	}

}
