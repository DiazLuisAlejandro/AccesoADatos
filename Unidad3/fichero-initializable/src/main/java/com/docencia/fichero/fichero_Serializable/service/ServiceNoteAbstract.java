package com.docencia.fichero.fichero_Serializable.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.docencia.fichero.fichero_Serializable.model.Note;
import com.docencia.fichero.fichero_Serializable.repository.INoteRepository;

public abstract class ServiceNoteAbstract implements IServiceNote{

    @Autowired
    INoteRepository iNoteRepository;

    public INoteRepository getiNoteRepository() {
        return iNoteRepository;
    }
    
    @Override
    public List<Note> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    
}
