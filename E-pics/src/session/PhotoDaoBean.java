package session;

import static javax.ejb.TransactionAttributeType.REQUIRED;
import static javax.ejb.TransactionManagementType.CONTAINER;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionManagement;
import javax.persistence.NamedQuery;
import javax.persistence.Query;

import entity.Photo;
import entity.User;
@Stateless
@Local(PhotoDao.class)
@Remote(PhotoDao.class)
@TransactionManagement(CONTAINER)
@TransactionAttribute(REQUIRED)
public class PhotoDaoBean extends GenericDaoBean<Photo, Integer> implements PhotoDao {

	

	@Override
	public List<Photo> najKSlikaAutora(int idUser) {
		Query q=em.createNamedQuery("najTop");
		q.setParameter("id", idUser);
		q.setMaxResults(1);
		List<Photo>photos=q.getResultList();
		return photos;
	}

	@Override
	public List<Photo> findPicsByUser(User user) {
		
		Query q=em.createNamedQuery("findAllPicturesByUserId");
		List<Photo> photos = new ArrayList<>();
		if(user!=null){
			q.setParameter("id", user.getId());
			photos = q.getResultList();
		}

		return photos;
	}

	@Override
	public void addPhoto(Photo p) {
		em.persist(p);

	}
	
	@Override
	public void updateProsecnaOcea(int novaOcena, int idSlike) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addToFavorites(int idSlike, int idUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ratePhoto(int ocena, int idSlike) {
		// TODO Auto-generated method stub
		Photo p = findById(idSlike);
		if(p.getRating()!=0)
			p.setRating((p.getRating()+ ocena)/2);
		else
			p.setRating(ocena);
		updatePhoto(p);
	}

	@Override
	public void updatePhoto(Photo photo) {
		em.merge(photo);

	}

	@Override
	public List<Photo> findPublicNewestPics() {
		String upit = "Select pic from Photo pic "
						+ " WHERE pic.publicType = true "
						+ " ORDER BY pic.uploadDate desc ";
		Query q = em.createQuery(upit).setMaxResults(15);
		List<Photo>photos=q.getResultList();
		return photos;
	}

	@Override
	public List<Photo> findPublicPhotoByUserID(int usrID) {
		Query q=em.createNamedQuery("findAllPicturesByUserIdPublicOrNot");
		q.setParameter("id", usrID);
		q.setParameter("publicPicture", true);
		
		List<Photo> photos = q.getResultList();
		
		return photos;
	}
	public void deletePhoto(Photo photo){
		em.remove(em.merge(photo));
	}

	@Override
	public List<Photo> findByUserCriteria(String imeAutora,
			String prezimeAutora, String photoTitle, String photoDesc,
			String tagName, String sizeOd, String sizeDo, boolean publicType) {
		String sqlSelect = "select p from Photo p  "
				+ "LEFT JOIN p.tagsPhotos t"
				+ "LEFT JOIN p.photosAlbums a "
				+ "LEFT JOIN a.user u "
				+ "where p.id >0 ";
		if(imeAutora!=null && imeAutora.length()>0)
			sqlSelect += " AND LOWER(u.firstName) LIKE:imeAutora";

		if(prezimeAutora!=null && prezimeAutora.length()>0)
			sqlSelect += " AND LOWER(u.lastName) LIKE :prezimeAutora";
			
		if(photoTitle!=null && photoTitle.length()>0)
			sqlSelect += " AND LOWER(p.title) LIKE:photoTitle" ;
		
		if(photoDesc!=null && photoDesc.length()>0)
			sqlSelect += " AND LOWER(p.description) LIKE:photoDesc" ;
		
		if(photoDesc!=null && photoDesc.length()>0)
			sqlSelect += " AND LOWER(t.text) LIKE:tagName" ;
		
		if(sizeOd!=null && sizeOd.length()>0)
			sqlSelect += " AND p.size >=:sizeOd";
		
		if(sizeDo!=null && sizeDo.length()>0)
			sqlSelect += " AND p.size <=:sizeDo";
		
		if(!publicType){
			sqlSelect += " AND p.publicType=:publicType " ;
			sqlSelect += " AND a.publicType=:publicType " ;
		}
		Query q = em.createQuery(sqlSelect);
		if(imeAutora!=null && imeAutora.length()>0)
			q.setParameter("imeAutora", '%'+imeAutora.toLowerCase()+'%') ;

		if(prezimeAutora!=null && prezimeAutora.length()>0)
			q.setParameter("prezimeAutora",'%'+ prezimeAutora.toLowerCase()+'%') ;
			
		if(photoTitle!=null && photoTitle.length()>0)
			q.setParameter("photoTitle", '%'+photoTitle.toLowerCase()+'%') ;
		
		if(photoDesc!=null && photoDesc.length()>0)
			q.setParameter("photoDesc",'%'+ photoDesc.toLowerCase()+'%') ;
		
		if(photoDesc!=null && photoDesc.length()>0)
			q.setParameter("tagName",'%'+ tagName.toLowerCase()+'%') ;
		if(!publicType){
			q.setParameter("publicType", !publicType) ;

			
		}
		if(sizeOd!=null && sizeOd.length()>0)
			q.setParameter("sizeOd", Double.parseDouble(sizeOd)) ;
		
		if(sizeDo!=null && sizeDo.length()>0)
			q.setParameter("sizeDo", Double.parseDouble(sizeDo)) ;
		return q.getResultList();
	}

}
