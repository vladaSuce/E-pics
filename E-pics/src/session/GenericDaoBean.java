package session;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class GenericDaoBean<T, ID extends Serializable> implements GenericDao<T, ID> {

	private Class<T> entityType;

	@PersistenceContext(unitName="epics")
	protected EntityManager em;

	@SuppressWarnings("unchecked")
	public GenericDaoBean() {
		entityType = (Class<T>)
		((ParameterizedType)getClass().getGenericSuperclass())
		.getActualTypeArguments()[0];
	}

	// Get type of entity
	public Class<T> getEntityType() {
		return entityType;
	}

	// Find by primary key.
	public T findById(ID id) {
		T entity;
		entity = em.find(entityType, id);
		return entity;
	}

	@SuppressWarnings("unchecked")
	// Find all entities
	public List<T> findAll() {
		Query q = em.createQuery("SELECT x FROM " + entityType.getSimpleName()+ " x");
		List<T> result = q.getResultList();
		return result;
	}

	// Find by criteria defined  in 'query'
	@SuppressWarnings("unchecked")
	public List<T> findBy(String query) {
		Query q = em.createQuery(query);
		List<T> result = q.getResultList();
		return result;
	}

	// Make an entity instance managed and persistent.
	public T persist(T entity) {
		em.persist(entity);
		return entity;
	}

	// Merge the state of the given entity into the current persistence context.
	public T merge(T entity) {
		entity = em.merge(entity);
		return entity;
	}

	// Remove the entity instance.
	public void remove(T entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	// Synchronize the persistence context to the underlying database.
	public void flush() {
		em.flush();
	}

	// Clear the persistence context, causing all managed entities to become detached.
	public void clear() {
		em.clear();
	}

}