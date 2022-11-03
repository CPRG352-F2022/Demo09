package services;

import dataaccess.NoteDB;
import dataaccess.UserDB;
import java.util.List;
import models.Note;
import models.User;

public class NoteService {
    public Note get(int id) throws Exception {
        NoteDB noteDB = new NoteDB();
        Note note = noteDB.get(id);
        return note;
    }
    
    public List<Note> getAll(String email) throws Exception {
        NoteDB noteDB = new NoteDB();
        List<Note> notes = noteDB.getAll(email);
        return notes;
    }
    
    public void insert(String title, String contents, String owner) throws Exception {
        Note note = new Note(0, title, contents);
        UserDB udb = new UserDB();
        User user = udb.getUser(owner);
        note.setOwner(user);
        NoteDB noteDB = new NoteDB();
        noteDB.insert(note);
    }
    
    public void update(int noteId, String title, String contents, String owner) throws Exception {
        NoteDB noteDB = new NoteDB();
        // retrieving the old note from the database
        Note note = noteDB.get(noteId);
        // setting the new information
        note.setTitle(title);
        note.setContents(contents);
        // if the owner has changed, retrieve the new user object
        UserDB udb = new UserDB();
        User user = udb.getUser(owner);
        note.setOwner(user);
        // update the note
        noteDB.update(note);
    }
    
    public void delete(int noteId) throws Exception {
        NoteDB noteDB = new NoteDB();
        Note note = noteDB.get(noteId);
        noteDB.delete(note);
    }
}
