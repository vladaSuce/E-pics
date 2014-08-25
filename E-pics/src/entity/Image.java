package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.InheritanceType.SINGLE_TABLE;
@MappedSuperclass
public abstract class Image implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7447716014129204818L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	protected int id;
	@Column(name = "location", unique = false, nullable = true)
	protected String location;
	@Column(name = "width", unique = false, nullable = true)
	protected int width;
	@Column(name = "height", unique = false, nullable = true)
	protected int height;
	@Column(name = "size", unique = false, nullable = true)
	protected double size;
	@Column(name = "uploadDate", unique = false, nullable = true)
	protected Date uploadDate;



	public Image() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", location=" + location + ", width="
				+ width + ", height=" + height + ", size=" + size
				+ ", uploadDate=" + uploadDate + "]";
	}

}
