package com.docencia.fichero.fichero_Serializable.repository;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.springframework.util.StringUtils;

import com.docencia.fichero.fichero_Serializable.model.Note;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class FileNoteRepository extends FileNoteAbstractRepository {
    
    private String nameFile;
    private Path path;
    private final ReentrantReadWriteLock lock=new ReentrantReadWriteLock();


    public FileNoteRepository(){
        this.nameFile="nore-repository.txt";
        try {
            this.path=verificarFichero();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    private Path verificarFichero() throws IOException{

        URL resource;
        
        resource=getClass().getClassLoader().getResource(nameFile);
        if (resource==null) {
            throw new IOException("El fichero no existe: "+nameFile);

        }

        return path=Paths.get(resource.getPath());
    }

    @Override
    public boolean exists(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }
    @Override
    public Note findById(String id) {
        Note elemento=new Note();
        return null;
    }

    @Override
    public Note find(Note note) {        
        return null;
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
        lock.writeLock().lock();
        try {
            List<Note> all = readAllInternal();
            if (StringUtils.isEmpty(all)) {
                note.setId(UUID.randomUUID().toString());
            }
            all.removeIf(n -> Objects.equals(n.getId(), note.getId()));
            all.add(note);
            writeAllInternal(all);
            return note;
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public boolean delete() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    private List<Note> readAllInternal() {
        XmlMapper xmlMapper=new XmlMapper();
        try {
            if (!Files.exists(path) || Files.size(path) == 0) return new ArrayList<>();
            Note[] store = xmlMapper.readValue(Files.readAllBytes(path), Note[].class);
            return new ArrayList<>(Arrays.asList(store));
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo XML", e);
        }
    }

    private void writeAllInternal(List<Note> items) {
        try {
            byte[] bytes = mapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(items);
            Files.write(path, bytes,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING,
                    StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new RuntimeException("Error escribiendo JSON", e);
        }
    }

    
    
}
