package entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import static javax.persistence.CascadeType.ALL;
@Entity
@Table(name="Photo")
@NamedQueries({
@NamedQuery(name="najTop",query = "SELECT pic  FROM User u,Photo pic,Album a "

+" WHERE u.id = :id AND pic.photosAlbums=a AND a.user=u order by pic.rating desc "),
@NamedQuery(
	    name="findPublicPictureByUserId",
	    query="SELECT pic FROM User u "
	    		+ "LEFT  JOIN album a on a.user_id=u.id "
	    		+ "LEFT  JOIN photo_album pa on pa.albumsphotos_id "
	    		+ "LEFT  JOIN photo pic on pic.id= pa.photosalbums_id "
	    		+" WHERE u.id = :id AND pic.public= true "),
@NamedQuery(name = "findAllPicturesByUserId", query = "SELECT pic  FROM User u,Photo pic,Album a "
	    		
	    		+" WHERE u.id = :id AND pic.photosAlbums=a AND a.user=u "),

@NamedQuery(name = "findAllPicturesByUserIdPublicOrNot", query = "SELECT pic  FROM User u,Photo pic,Album a "
	    		
	    		+" WHERE u.id = :id AND pic.photosAlbums=a AND a.user=u AND pic.Public = :publicPicture")})

public class Photo extends Image implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 805282628196769907L;
	@Column(name = "title", unique = false, nullable = true)
	protected String title;
	@Column(name = "description", unique = false, nullable = true)
	protected String description;
	@Column(name = "public", unique = false, nullable = true)
	protected boolean Public;
	@Column(name = "tags_allowed", unique = false, nullable = true)
	protected boolean tagsAllowed;
	@Column(name = "notes_allowed", unique = false, nullable = true)
	protected boolean notesAllowed;
	@Column(name = "comments_allowed", unique = false, nullable = true)
	protected boolean commentsAllowed;
	@Column(name = "rating", unique = false, nullable = true)
	protected double rating;
	@Column(name = "thumnail_location", unique = false, nullable = true)
	protected String thumbnailLocation;
	@ManyToMany( cascade={ALL},fetch = FetchType.EAGER,mappedBy="photoTags")
	protected ArrayList<Tag> tagsPhotos;
	@OneToMany(cascade={ALL}, fetch = FetchType.EAGER,mappedBy="photo")
	protected ArrayList<Note> photoNotes;
	@OneToMany(cascade={ALL}, fetch = FetchType.EAGER,mappedBy="photoComment")
	protected ArrayList<Comment> photoComments;
	@OneToMany(cascade={ALL}, fetch = FetchType.EAGER, mappedBy = "photoRating")
	protected ArrayList<Rating> photoRatings;
	@ManyToMany(fetch = FetchType.EAGER)
	protected ArrayList<Album> photosAlbums;



	public Photo() {
		super();
		// TODO Auto-generated constructor stub
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

	public boolean getTagsAllowed() {
		return tagsAllowed;
	}

	public void setTagsAllowed(boolean tagsAllowed) {
		this.tagsAllowed = tagsAllowed;
	}

	public boolean getNotesAllowed() {
		return notesAllowed;
	}

	public void setNotesAllowed(boolean notesAllowed) {
		this.notesAllowed = notesAllowed;
	}

	public boolean getCommentsAllowed() {
		return commentsAllowed;
	}

	public void setCommentsAllowed(boolean commentsAllowed) {
		this.commentsAllowed = commentsAllowed;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getThumbnailLocation() {
		return thumbnailLocation;
	}

	public void setThumbnailLocation(String thumbnailLocation) {
		this.thumbnailLocation = thumbnailLocation;
	}
	
	public ArrayList<Tag> getTagsPhotos() {
		return tagsPhotos;
	}



	public void setTagsPhotos(ArrayList<Tag> tagsPhotos) {
		this.tagsPhotos = tagsPhotos;
	}



	public ArrayList<Note> getPhotoNotes() {
		return photoNotes;
	}



	public void setPhotoNotes(ArrayList<Note> photoNotes) {
		this.photoNotes = photoNotes;
	}



	public ArrayList<Comment> getPhotoComments() {
		return photoComments;
	}



	public void setPhotoComments(ArrayList<Comment> photoComments) {
		this.photoComments = photoComments;
	}



	public ArrayList<Rating> getPhotoRatings() {
		return photoRatings;
	}



	public void setPhotoRatings(ArrayList<Rating> photoRatings) {
		this.photoRatings = photoRatings;
	}



	public ArrayList<Album> getPhotosAlbums() {
		return photosAlbums;
	}



	public void setPhotosAlbums(ArrayList<Album> photosAlbums) {
		this.photosAlbums = photosAlbums;
	}
	


	@Override
	public String toString() {
		return super.getLocation() + "Photo [title=" + title + ", description=" + description
				+ ", Public=" + Public + ", tagsAllowed=" + tagsAllowed
				+ ", notesAllowed=" + notesAllowed + ", commentsAllowed="
				+ commentsAllowed + ", rating=" + rating
				+ ", thumbnailLocation=" + thumbnailLocation + "]";
	}
	

}
