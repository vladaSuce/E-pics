package entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;
@Entity
@Table(name="Album")
public class Album implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1545590263621056407L;
	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GeneratedValue(strategy = IDENTITY)
	protected int id;
	@Column(name = "title", nullable = true, unique = false)
	protected String title;
	@Column(name = "description", nullable = true, unique = false)
	protected String description;
	@Column(name = "public", nullable = true, unique = false)
	protected boolean Public;
	@ManyToOne(cascade={ALL},fetch = FetchType.EAGER)
	protected User user;
	
	@OneToOne(cascade={ALL}, fetch = FetchType.EAGER)
	private User userFavorite;
	@ManyToMany(cascade={ALL}, fetch = FetchType.EAGER, mappedBy = "photosAlbums")
	private ArrayList<Photo> albumsPhotos;



	public Album() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getPublic() {
		return Public;
	}

	public void setPublic(boolean public1) {
		Public = public1;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUserFavorite() {
		return userFavorite;
	}

	public void setUserFavorite(User userFavorite) {
		this.userFavorite = userFavorite;
	}

	public ArrayList<Photo> getAlbumsPhotos() {
		return albumsPhotos;
	}

	public void setAlbumsPhotos(ArrayList<Photo> albumsPhotos) {
		this.albumsPhotos = albumsPhotos;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", title=" + title + ", description="
				+ description + ", Public=" + Public + "]";
	}

}
