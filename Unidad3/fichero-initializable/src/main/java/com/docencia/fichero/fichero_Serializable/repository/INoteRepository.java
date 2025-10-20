package com.docencia.fichero.fichero_Serializable.repository;

import java.util.List;

import com.docencia.fichero.fichero_Serializable.model.Note;

public interface INoteRepository {
    public boolean exists(String id);
    public Note findById(String id);
    public List<Note> findAll();
    public Note save(Note note);
    public boolean delete();

}
