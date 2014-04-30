package servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import entity.Image;
import session.UserDao;


public class EditProfileController extends HttpServlet {

	private static final long serialVersionUID = 5161949512237886627L;

	private static Logger log = Logger.getLogger(EditProfileController.class);

	@EJB
	private UserDao korisnikDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//response.setContentType("application/rss+xml");
			response.setCharacterEncoding("UTF-8");
			getServletContext().getRequestDispatcher("/updatePersonalData.html").forward(request, response);

		} catch (ServletException e) {
			log.error(e);
			throw e;
		} catch (IOException e) {
			log.error(e);
			throw e;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		String ime = null;
		String prezime = null;
		Image slika = null;
	}
}
//		try {
//			List<Image> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
//			for (Image item : items) {
//				if (item.isFormField()) {
//
//					String fieldname = item.getFieldName();
//					String fieldvalue = item.getString();
//
//					if (fieldname.equals("ime"))
//						ime = fieldvalue;
//					else if (fieldname.equals("prezime"))
//						prezime = fieldvalue;
//
//				} else {
//					if (item.getFieldName().equals("slika"))
//						slika = item;
//				}
//			}

//		}
		

