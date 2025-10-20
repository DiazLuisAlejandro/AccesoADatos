package com.docencia.fichero.fichero_Serializable.repository;

import org.junit.jupiter.api.Test;

public class FileNoteRepositoryTest {
    FileNoteRepository fileNoteRepository;

    @Test
    void createFileTest(){
        fileNoteRepository=new FileNoteRepository();
    }
}
