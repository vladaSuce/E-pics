package entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import static javax.persistence.CascadeType.ALL;
@Entity
@Table(name="Profile_image")
public class ProfileImage extends Image implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2376134217640071218L;
	@OneToOne(cascade={ALL}, fetch = FetchType.EAGER)
	protected User user;



	public ProfileImage() {
		super();
	
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}
	

}
