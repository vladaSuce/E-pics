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
import javax.persistence.TypedQuery;

import entity.User;


@Stateless
@Local(UserDao.class)
@Remote(UserDao.class)
@TransactionManagement(CONTAINER)
@TransactionAttribute(REQUIRED)

public class UserDaoBean extends GenericDaoBean<User, Integer> implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public User logIn(String userName, String password) throws Exception {
		if(userName.equalsIgnoreCase("") || userName == null) {
			throw new Exception("Username is not entered!");
		}
		
		if(password.equalsIgnoreCase("") || password == null) {
			throw new Exception("Password is not entered!");
		}
		
		Query q = em.createNamedQuery("findUser");
		q.setParameter("userName", userName);
		q.setParameter("password", password);
		
		List<User> users = q.getResultList();
		
		if (users.size() == 0) {
			throw new Exception("No user with provided username and password!!!");
		}
		else {
			return users.get(0);
		}
}

	@Override
	public void insertUserWithPicture(User user, String imagePath) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		em.persist(user);
		
	}

	@Override
	public User updateUserWithPicture(User updatedUser, String imagePath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User updatedUser) {
		// TODO Auto-generated method stub
		em.merge(updatedUser);;
	}

	@Override
	public User findUser(String emailAdress,String password) {
		User usr=null;
		TypedQuery<User> q = em.createNamedQuery("findUser", User.class);
		q.setParameter("emailAdress", emailAdress);
		q.setParameter("password", password);
		List<User> users = q.getResultList();

		if(users.size() == 1)
			usr= users.get(0);
		return usr;
	}
		
	

	@Override
	public boolean userExists(String email) {
		boolean retVal=false;
		TypedQuery<User>q=em.createNamedQuery("findUserByEmail", User.class);
		q.setParameter("emailAdress", email);
		List<User>users =q.getResultList();
		if(!users.isEmpty())
			retVal= true;
		return retVal;
	}

	@Override
	public User findUserByEmail(String email) {
		User retVal=null;
		TypedQuery<User>q=em.createNamedQuery("findUserByEmail", User.class);
		q.setParameter("emailAdress", email);
		List<User>users =q.getResultList();
		if(!users.isEmpty())
			retVal= users.get(0);
		return retVal;
	}
	public User findUserByPic(int id_pic){
		String sqlSelect = "select u from Photo p  "
				+ "LEFT JOIN p.tagsPhotos t"
				+ "LEFT JOIN p.photosAlbums a "
				+ "LEFT JOIN a.user u "
				+ "where p.id=:id";
		Query q= em.createQuery(sqlSelect);
		q.setParameter("id", id_pic);
		List<User>users=q.getResultList();
		System.out.println(users.toString());
			return users.get(0);
		
	}
	public User findUserByID(int id_user){
		Query q= em.createQuery("SELECT u from User u "
				+ "where u.id = :id");
		q.setParameter("id", id_user);
		List<User>users=q.getResultList();
		
			return users.get(0);
		
	}

}
