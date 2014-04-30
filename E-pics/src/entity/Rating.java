package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;
@Entity
@Table(name="Rating")
public class Rating implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3996078000078640861L;
	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GeneratedValue(strategy = IDENTITY)
	protected int id;
	@Column(name = "vote", nullable = true, unique = false)
	protected int vote;
	@ManyToOne(cascade={ALL}, fetch = FetchType.EAGER)
	protected Photo photoRating;
	@ManyToOne(cascade={ALL}, fetch = FetchType.EAGER)
	protected User userRating;

	public Rating() {
		super();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}
	

	public Photo getPhotoRating() {
		return photoRating;
	}


	public void setPhotoRating(Photo photoRating) {
		this.photoRating = photoRating;
	}


	public User getUserRating() {
		return userRating;
	}


	public void setUserRating(User userRating) {
		this.userRating = userRating;
	}


	@Override
	public String toString() {
		return "Rating [id=" + id + ", vote=" + vote + "]";
	}

}
