package session;

import entity.Image;
import entity.ProfileImage;

public interface ProfileImageDao extends GenericDao<ProfileImage, Integer> {
	public void addProfileImage(Image img);
	public void updateProfileImage(Image img);
}
