package com.docencia.fichero.fichero_Serializable.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.docencia.fichero.fichero_Serializable.model.Note;

public class FileNoteRepositoryTest {
    FileNoteRepository fileNoteRepository;
    Note elemento;
    String id="001";
    String title="Mi titulo";
    String content="Contenido";
    Note elementoFind;

    @BeforeEach
    void beforeEach(){
        fileNoteRepository=new FileNoteRepository();
        elemento=new Note(id,title,content);
        elementoFind= fileNoteRepository.findById(id);
        Assertions.assertNull(elementoFind, "El elemento debe ser null");
    }

    @AfterEach
    void afterEach(){
        elementoFind= fileNoteRepository.findById(id);
        Assertions.assertNotNull(elementoFind, "El elemento no debe ser null");

    }

    @Test
    void createFileTest(){
        Assertions.assertNotNull(fileNoteRepository, "El repositorio no debe de ser nulo");
    }

    @Test
    void insertNoteTest(){
        Note result= fileNoteRepository.findById(id);
        Assertions.assertNotNull(result, "El resultado no debe de ser nulo");
        Assertions.assertEquals(result,result,"El valor no es el esperado");
    }
}