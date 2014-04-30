package session;

import static javax.ejb.TransactionAttributeType.REQUIRED;
import static javax.ejb.TransactionManagementType.CONTAINER;

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
		q.setParameter("id", user.getId());
		
		List<Photo> photos = q.getResultList();
		
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

	}

	@Override
	public void updatePhoto(Photo photo) {
		em.merge(photo);

	}

	@Override
	public List<Photo> findPublicNewestPics() {
		String upit = "Select pic from Photo pic "
						+ " WHERE pic.Public = true "
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

}
