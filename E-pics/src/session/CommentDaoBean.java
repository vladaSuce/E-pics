package session;

import static javax.ejb.TransactionAttributeType.REQUIRED;
import static javax.ejb.TransactionManagementType.CONTAINER;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionManagement;

import entity.Comment;
@Stateless
@Local(CommentDao.class)
@Remote(CommentDao.class)
@TransactionManagement(CONTAINER)
@TransactionAttribute(REQUIRED)
public class CommentDaoBean extends GenericDaoBean<Comment, Integer> implements
		CommentDao {

	@Override
	public Class<Comment> getEntityType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
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
	public List<Comment> lastComments(int idUser) {
		// TODO Auto-generated method stub
		return null;
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
