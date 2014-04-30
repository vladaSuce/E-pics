package session;

import entity.Tag;

public interface TagDao extends GenericDao<Tag, Integer> {
	public void addTag(Tag tag);
	public void deleteTag(Tag tag);
}
