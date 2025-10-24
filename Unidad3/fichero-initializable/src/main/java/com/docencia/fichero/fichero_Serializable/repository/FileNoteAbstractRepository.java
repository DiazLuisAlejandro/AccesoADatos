package com.docencia.fichero.fichero_Serializable.repository;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.docencia.fichero.fichero_Serializable.model.Note;
import com.fasterxml.jackson.databind.ObjectMapper;


public abstract class FileNoteAbstractRepository implements INoteRepository{

    private String nameFile;
    private Path path;
    ObjectMapper mapper;
    private final ReentrantReadWriteLock lock=new ReentrantReadWriteLock();

    public FileNoteAbstractRepository(){}

    public FileNoteAbstractRepository(String nameFile,ObjectMapper mapper){
        this.nameFile=nameFile;
        path=verificarFichero();
        this.mapper=mapper;
    }

    private Path verificarFichero(){

        URL resource;
        
        resource=getClass().getClassLoader().getResource(nameFile);
        return path=Paths.get(resource.getPath());
    }

    private List<Note> readAllInternal() {
        mapper=new ObjectMapper();
        try {
            if (!Files.exists(path) || Files.size(path) == 0) return new ArrayList<>();
            Note[] store = mapper.readValue(Files.readAllBytes(path), Note[].class);
            return new ArrayList<>(Arrays.asList(store));
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo XML", e);
        }
    }

    @Override
    public boolean exists(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }
    @Override
    public Note findById(String id) {

        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

     @Override
    public Note find(Note note) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Note> findAll() {
        lock.readLock().lock();
        try {
            return Collections.unmodifiableList(readAllInternal());
        } finally {
            lock.readLock().unlock();
        }
    }
    @Override
    public Note save(Note note) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
    @Override
    public boolean delete() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
