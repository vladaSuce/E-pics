package session;

import java.util.List;

import entity.Photo;
import entity.User;

public interface PhotoDao extends GenericDao<Photo, Integer> {
	public List<Photo> najKSlikaAutora(int idUser);
	public List<Photo>findPicsByUser(User usr);
	public List<Photo>findPublicPhotoByUserID(int usrID);
	public List<Photo>findPublicNewestPics();
	public void addPhoto(Photo p);
	public void updateProsecnaOcea(int novaOcena,int idSlike);
	public void addToFavorites(int idSlike,int idUser);
	public void ratePhoto(int ocena,int idSlike);
	public void updatePhoto(Photo photo);
	public Photo findById(Integer id);
	public List<Photo> findByUserCriteria(String imeAutora,
			String prezimeAutora, String photoTitle, String photoDesc,
			String tagName, String sizeOd, String sizeDo, boolean publicType);
	
}
