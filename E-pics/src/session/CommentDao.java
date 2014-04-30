package session;

import java.util.List;

import entity.Comment;

public interface CommentDao extends GenericDao<Comment,Integer> {
	public List<Comment>lastComments(int idUser);
	public void addComment(Comment comm,int idSlike);
	public void removeComment(int idComment,int idUser);
}
