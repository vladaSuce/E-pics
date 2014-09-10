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

import entity.Album;
import entity.User;

@Stateless
@Local(AlbumDao.class)
@Remote(AlbumDao.class)
@TransactionManagement(CONTAINER)
@TransactionAttribute(REQUIRED)
public class AlbumDaoBean extends GenericDaoBean<Album, Integer> implements
		AlbumDao {

	@Override
	public Class<Album> getEntityType() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Album> findAlbumsById(User user2) {
		Query q = em.createQuery("select x from Album x where x.user = :user "  );
		q.setParameter("user", user2);
		List<Album> albums = q.getResultList();
		return albums;
	}

	@Override
	public List<Album> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Album> findBy(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Album persist(Album entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Album merge(Album entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Album entity) {
		em.remove(em.merge(entity));

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
	public void insertAlbum(Album album) {
		em.persist(album);

	}

	@Override
	public Album findById(Integer aId) {
		Query q = em.createQuery("select x from Album x where x.id=:id "  );
		q.setParameter("id", aId);
		System.out.println(q.toString()+" querry");
		List<Album> albums = q.getResultList();
		System.out.println(albums.toString());
		return albums.get(0);
	}

}
