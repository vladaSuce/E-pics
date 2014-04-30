package entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;
@Entity
@Table(name="User")
@NamedQueries({
@NamedQuery(name="findOwnerOfPic",query =" SELECT u from User u,Picture pic,Album a  where p.id = :id "
		+ " and pic.photosAlbums=a and a.user=u"),
@NamedQuery(
	    name="findUser",
	    query="SELECT u FROM User u WHERE u.emailAdress like :emailAdress AND u.password LIKE :password"),
@NamedQuery(name = "findUserByEmail", query = "SELECT u FROM User u WHERE u.emailAdress like :emailAdress") })

public class User implements Serializable {
	/**
	 * 
	 */
	protected static final long serialVersionUID = -5543489906557040927L;

	public enum Gender {
		Male, Female
	};

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	protected int id;
	@Column(name = "email_adress", nullable = true, unique = false)
	protected String emailAdress;
	@Column(name = "password", nullable = true, unique = false)
	protected String password;
	@Column(name = "first_name", nullable = true, unique = false)
	protected String firstName;
	@Column(name = "last_name", nullable = true, unique = false)
	protected String lastName;
	@Column(name = "date_of_birth", nullable = true, unique = false)
	protected String dateOfBirth;
	@Column(name = "email_notifications", nullable = true, unique = false)
	protected boolean emailNotifications;
	@Column(name = "gender", nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	protected Gender gender;
	
	@OneToOne(cascade={ALL}, fetch = FetchType.EAGER, mappedBy="user")
	protected ProfileImage userProfileImage;
	
	@OneToMany(cascade={ALL}, fetch = FetchType.EAGER,mappedBy="user")
	protected ArrayList<Album> albums;
	
	@OneToOne(cascade={ALL}, fetch = FetchType.EAGER, mappedBy = "userFavorite")
	protected Album userFavoriteAlbum;
	
	@OneToMany(cascade={ALL}, fetch = FetchType.EAGER, mappedBy = "userRating")
	protected ArrayList<Rating> userRatings;
	
	@OneToMany(cascade={ALL}, fetch = FetchType.EAGER, mappedBy = "userComments")
	protected ArrayList<Comment> comments;
	
	@ManyToMany(cascade={ALL}, fetch = FetchType.EAGER, mappedBy = "userFollow")
	protected ArrayList<User> followers;
	@ManyToMany
	protected ArrayList<User>userFollow;

	public User() {
		super();
		this.gender=Gender.Male;
		this.emailNotifications=false;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailAdress() {
		return emailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean isEmailNotifications() {
		return emailNotifications;
	}

	public void setEmailNotifications(boolean emailNotifications) {
		this.emailNotifications = emailNotifications;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	
	public ProfileImage getUserProfileImage() {
		return userProfileImage;
	}



	public void setUserProfileImage(ProfileImage userProfileImage) {
		this.userProfileImage = userProfileImage;
	}



	public ArrayList<Album> getAlbums() {
		return albums;
	}



	public void setAlbums(ArrayList<Album> albums) {
		this.albums = albums;
	}



	public Album getUserFavoriteAlbum() {
		return userFavoriteAlbum;
	}



	public void setUserFavoriteAlbum(Album userFavoriteAlbum) {
		this.userFavoriteAlbum = userFavoriteAlbum;
	}



	public ArrayList<Rating> getUserRatings() {
		return userRatings;
	}



	public void setUserRatings(ArrayList<Rating> userRatings) {
		this.userRatings = userRatings;
	}



	public ArrayList<Comment> getComments() {
		return comments;
	}



	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}



	public ArrayList<User> getFollowers() {
		return followers;
	}



	public void setFollowers(ArrayList<User> followers) {
		this.followers = followers;
	}



	public ArrayList<User> getUserFollow() {
		return userFollow;
	}



	public void setUserFollow(ArrayList<User> userFollow) {
		this.userFollow = userFollow;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", emailAdress=" + emailAdress
				+ ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ ", emailNotifications=" + emailNotifications + ", gender="
				+ gender + "]";
	}

}
