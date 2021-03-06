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

import entity.Comment;
import entity.User;
@Stateless
@Local(CommentDao.class)
@Remote(CommentDao.class)
@TransactionManagement(CONTAINER)
@TransactionAttribute(REQUIRED)
public class CommentDaoBean extends GenericDaoBean<Comment, Integer> implements
		CommentDao {
private Class<Comment> entityClass;
	@Override
	public Class<Comment> getEntityType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment findById(Integer id) {
		Query q = em.createQuery("Select c from Comment c  "
				+ "where c.id=:id ");
				q.setParameter("id", id);
		return (Comment) q.getResultList().get(0);
	}

	@Override
	public List<Comment> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> findBy(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment persist(Comment entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment merge(Comment entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Comment entity) {
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
	public List<Comment> lastComments(User user) {

		Query q = em.createQuery("Select c from Comment c  "
				+ "where c.userComments=:user ");
				q.setParameter("user", user);
		return q.getResultList();
	}

	@Override
	public void addComment(Comment comm, int idSlike) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeComment(int idComment, int idUser) {
		// TODO Auto-generated method stub

	}

}
