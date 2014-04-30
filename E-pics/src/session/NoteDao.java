package session;

import entity.Note;

public interface NoteDao extends GenericDao<Note, Integer> {
	public void addNote(Note note);
	public void deleteNote(Note note);

}
