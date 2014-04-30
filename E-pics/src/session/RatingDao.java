package session;

import java.util.List;

import entity.Photo;
import entity.Rating;
import entity.User;

public interface RatingDao extends GenericDao<Rating, Integer> {
	
	public void addRateing(Rating rating);
	public List<Rating>findRatingForUserPic(User usr,Photo pic);
}
