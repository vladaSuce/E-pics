package session;

import java.util.List;

import entity.Comment;
import entity.User;

public interface CommentDao extends GenericDao<Comment,Integer> {
	public List<Comment>lastComments(User idUser);
	public void addComment(Comment comm,int idSlike);
	public void removeComment(int idComment,int idUser);
}
