package entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Tag")
public class Tag implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2915265365525834166L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	protected int id;
	@Column(name = "text", nullable = true, unique = false)
	protected String text;

	@ManyToMany( fetch = FetchType.EAGER)
	protected ArrayList<Photo> photoTags = new ArrayList<Photo>();

	public Tag() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	

	public ArrayList<Photo> getPhotoTags() {
		return photoTags;
	}

	public void setPhotoTags(ArrayList<Photo> photoTags) {
		this.photoTags = photoTags;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", text=" + text + "]";
	}

}
