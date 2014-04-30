package session;

import java.util.List;

import entity.Image;
import entity.ProfileImage;

public class ProfileImageDaoBean extends GenericDaoBean<ProfileImage, Integer>
		implements ProfileImageDao {

	@Override
	public Class<ProfileImage> getEntityType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProfileImage findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProfileImage> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProfileImage> findBy(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProfileImage persist(ProfileImage entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProfileImage merge(ProfileImage entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(ProfileImage entity) {
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
	public void addProfileImage(Image img) {
		em.persist(img);

	}
	@Override
	public void updateProfileImage(Image img){
		em.merge(img);
		
	}

}
