package com.docencia.fichero.fichero_Serializable.service;

import java.util.List;

import com.docencia.fichero.fichero_Serializable.model.Note;

public interface IServiceNote {
    public boolean exists(String id);

    public Note findById(String id);

    public List<Note> findAll();

    public Note save(Note note);

    public boolean delete();
    
    public String noteToString(Note note);

    public Note stringToNote(String string);
}
