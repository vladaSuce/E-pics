package session;

import java.util.List;

import entity.Album;
import entity.Photo;
import entity.User;

public interface AlbumDao extends GenericDao<Album, Integer> {
	public void insertAlbum(Album album);
	public List<Album> findAlbumsById(User user);
	public Album findById(Integer id);
}
