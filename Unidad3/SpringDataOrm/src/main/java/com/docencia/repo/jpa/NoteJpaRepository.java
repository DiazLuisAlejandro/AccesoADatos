package com.docencia.repo.jpa;

import java.util.List;
import java.util.UUID;

import com.docencia.model.Note;
import com.docencia.repo.INoteRepository;

import io.micrometer.common.util.StringUtils;

public class NoteJpaRepository implements INoteRepository{

    private final ISqliteNoteRepository repository;

    /**
     * Constructor pordefecto
     */
    public NoteJpaRepository() {
        this.repository = null;
    }

    /**
     * Constructorcon el repository inicializado
     * @param repository
     */
    public NoteJpaRepository(ISqliteNoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean exists(String id) {
        return repository.existsById(id);
    }

    @Override
    public Note findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Note find(Note note) {
       return findById(note.getId());
    }

    @Override
    public List<Note> findAll() {
        return repository.findAll();
    }

    @Override
    public Note save(Note note) {
        if (findById(note.getId())==null || StringUtils.isEmpty(note.getId())) {
            note.setId(UUID.randomUUID().toString());
        }
        return repository.save(note);
    }

    @Override
    public boolean delete(String id) {
        if (findById(id)!=null) {
            repository.deleteById(id);
            return true;
        }
        return true;
    }

}
