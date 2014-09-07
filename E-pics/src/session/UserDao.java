package session;

import entity.User;


public interface UserDao extends GenericDao<User, Integer> {

	public User logIn(String userName,String password) throws Exception;
	public void insertUserWithPicture(User user,String imagePath);
	public void insertUser(User user);
	public User updateUserWithPicture(User updatedUser,String imagePath);
	public void updateUser(User updatedUser);
	public boolean userExists(String emailAdress);
	public User findUser(String email,String password);
	public User findUserByEmail(String email);
	public User findUserByPic(int id_pic);
	public User findUserByID(int id_user);
}
