package session;

import java.util.List;

import entity.Note;

public class NoteDaoBean extends GenericDaoBean<Note, Integer> implements
		NoteDao {

	@Override
	public Class<Note> getEntityType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Note findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Note> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Note> findBy(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Note persist(Note entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Note merge(Note entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Note entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addNote(Note note) {
		em.persist(note);

	}

	@Override
	public void deleteNote(Note note) {
		em.remove(note);

	}

}
