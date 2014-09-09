package entity;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="Comment")
public class Comment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8078349639667215372L;
	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GeneratedValue(strategy = IDENTITY)
	protected int id;
	@Column(name = "title", nullable = true, unique = false)
	protected String title;
	@Column(name = "contents", nullable = true, unique = false)
	protected String contents;
	@Column(name = "date", nullable = true, unique = false)
	protected Date date;
	@ManyToOne( fetch = FetchType.EAGER)
	protected Photo photoComment;
	@ManyToOne( fetch = FetchType.EAGER)
	protected User userComments;



	public Comment() {
	
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

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Photo getPhotoComment() {
		return photoComment;
	}

	public void setPhotoComment(Photo photoComment) {
		this.photoComment = photoComment;
	}

	public User getUserComments() {
		return userComments;
	}

	public void setUserComments(User userComments) {
		this.userComments = userComments;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", title=" + title + ", contents="
				+ contents + ", date=" + date + "]";
	}

}
