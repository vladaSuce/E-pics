package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;
@Entity
@Table(name="Note")
public class Note implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 964946604207048977L;
	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GeneratedValue(strategy = IDENTITY)
	protected int id;
	@Column(name = "caption", nullable = true, unique = false)
	protected String caption;
	@Column(name = "width", nullable = true, unique = false)
	protected int width;
	@Column(name = "height", nullable = true, unique = false)
	protected int height;
	@Column(name = "x", nullable = true, unique = false)
	protected int x;
	@Column(name = "y", nullable = true, unique = false)
	protected int y;

	@ManyToOne( fetch = FetchType.EAGER)
	protected Photo photo;



	public Note() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", caption=" + caption + ", width=" + width
				+ ", height=" + height + ", x=" + x + ", y=" + y + "]";
	}

}
