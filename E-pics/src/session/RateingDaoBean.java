package session;

import static javax.ejb.TransactionAttributeType.REQUIRED;
import static javax.ejb.TransactionManagementType.CONTAINER;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionManagement;
import javax.persistence.Query;

import entity.Photo;
import entity.Rating;
import entity.User;
@Stateless
@Local(RatingDao.class)
@Remote(RatingDao.class)
@TransactionManagement(CONTAINER)
@TransactionAttribute(REQUIRED)
public class RateingDaoBean extends GenericDaoBean<Rating, Integer> implements
		RatingDao {

	@Override
	public Class<Rating> getEntityType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rating findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rating> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rating> findBy(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rating persist(Rating entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rating merge(Rating entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Rating entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRateing(Rating rating) {
		em.persist(rating);

	}
	public List<Rating>findRatingForUserPic(User usr,Photo pic){
		Query q = em.createQuery("Select r from Rating r,User u,Photo p "
				+ "where u=:user and p=:photo and r.userRating=u and r.photoRating=p");
				q.setParameter("user", usr);
				q.setParameter("photo", pic);
		return q.getResultList();
	}

}
