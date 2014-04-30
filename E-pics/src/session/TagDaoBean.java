package session;

import static javax.ejb.TransactionAttributeType.REQUIRED;
import static javax.ejb.TransactionManagementType.CONTAINER;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionManagement;

import entity.Tag;
@Stateless
@Local(TagDao.class)
@Remote(TagDao.class)
@TransactionManagement(CONTAINER)
@TransactionAttribute(REQUIRED)
public class TagDaoBean extends GenericDaoBean<Tag, Integer> implements TagDao {

	@Override
	public Class<Tag> getEntityType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tag findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tag> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tag> findBy(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tag persist(Tag entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tag merge(Tag entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Tag entity) {
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
	public void addTag(Tag tag) {
		em.persist(tag);

	}

	@Override
	public void deleteTag(Tag tag) {
		em.remove(tag);

	}

}
