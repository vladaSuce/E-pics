package servlet;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import entity.Album;
import entity.Image;
import entity.Photo;
import entity.User;
import session.AlbumDao;
import session.PhotoDao;

public class AddPictureController extends HttpServlet {
	
	private static final long serialVersionUID = 6938560193524567545L;

	private static Logger log = Logger.getLogger(AddPictureController.class);

	
	@EJB
	private PhotoDao pictureDao;
	@EJB
	private AlbumDao albumDao;
	
	private File tmpDir;
	private File destinationDir;
 

	
	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{		

			Photo photo = new Photo();
			
			System.out.println(request.getParameter("album11"));
			DiskFileItemFactory factory = new DiskFileItemFactory();	// Create a factory for disk-based file items
			factory.setSizeThreshold(2000000);							// Set factory constraints
			ServletFileUpload upload = new ServletFileUpload(factory);	// Create a new file upload handler
			upload.setSizeMax(3000000);									// Set overall request size constraint
			List items = upload.parseRequest(request);					// Parse the request
			Iterator iter = items.iterator();							// Process the uploaded items
			
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				
				 //photo.setSize(image.get);
				String filename = item.getName();
				
				System.out.println("--------------------------------------");
				System.out.println(item.getFieldName());
				System.out.println(item.getString());
				System.out.println("--------------------------------------");
				
				if (item.isFormField()) {
					String name  = item.getFieldName();
					String value = item.getString();
					
					if(name.equals("photoTitle"))
						photo.setTitle(value);
					
					if(name.equals("photoPublic"))
						if(value!=null)
							photo.setPublic(true);
						else
							photo.setPublic(false);
					
					if(name.equals("comments_allowed"))
						if(value!=null)
							photo.setCommentsAllowed(true);
						else
							photo.setCommentsAllowed(false);
					if(name.equals("notes_allowed"))
						if(value!=null)
							photo.setNotesAllowed(true);
						else
							photo.setNotesAllowed(false);
					if(name.equals("tags_allowed"))
						if(value!=null)
							photo.setTagsAllowed(true);
						else
							photo.setTagsAllowed(false);
					
					if(name.equals("album11")){
						int album_id=Integer.parseInt(value);
						Album alb=albumDao.findById(album_id);
						ArrayList<Album>allalb=new ArrayList<>();
						allalb.add(alb);
						photo.setPhotosAlbums(allalb);
						
					}
				}
				else {
					
					long sizeInBytes = item.getSize();
					
					int idx = filename.lastIndexOf("//");
					
					if (idx != -1) {
						filename = filename.substring(idx + 1);
					}
					
					if (sizeInBytes != 0) {
						String lokacija = getServletContext().getRealPath("") + "/img/" + filename;
						
						File uploadedFile = new File(lokacija);
						
						item.write(uploadedFile);
						photo.setLocation("/img/" + filename);
						BufferedImage bimg = ImageIO.read(uploadedFile);
						photo.setWidth(bimg.getWidth());
						photo.setHeight(bimg.getHeight());
						double bytes = uploadedFile.length();
						double kilobytes = (bytes /	1024);
						photo.setSize(kilobytes);
					}
				}
			}
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			photo.setUploadDate(date);
			pictureDao.updatePhoto(photo);
			
	

			
			response.sendRedirect("IndexController");
		}
		catch (Exception e) {
			log.error(Calendar.getInstance().getTime() + " - Registering new blogger unsuccessful.\n\nError:\n" + e.getMessage() + "\n");
			System.out.println(e.getStackTrace().toString());
			System.out.println(e);
			//String link = "<br/><br/><a href=\"index.jsp\">register.jsp</a><br/><br/><a href=\"Top10PostsController\">home</a>";
			//request.getSession().setAttribute("error", e.getMessage() + link);
			response.sendRedirect("error.jsp");
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
