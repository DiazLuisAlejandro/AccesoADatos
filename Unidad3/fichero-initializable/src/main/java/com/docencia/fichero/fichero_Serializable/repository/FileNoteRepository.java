package com.docencia.fichero.fichero_Serializable.repository;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.docencia.fichero.fichero_Serializable.model.Note;

public class FileNoteRepository implements INoteRepository {
    
    private String nameFile;


    public FileNoteRepository(){
        this.nameFile="nore-repository.txt";
        try {
            verificarFichero();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    private void verificarFichero() throws IOException{

        URL resource;
        
        resource=getClass().getClassLoader().getResource(nameFile);
        if (resource==null) {
            throw new IOException("El fichero no existe: "+nameFile);

        }
    }

    @Override
    public boolean exists(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }
    @Override
    public Note findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
    @Override
    public List<Note> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
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
