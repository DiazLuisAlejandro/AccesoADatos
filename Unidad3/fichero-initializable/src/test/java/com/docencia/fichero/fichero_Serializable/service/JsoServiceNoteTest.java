package com.docencia.fichero.fichero_Serializable.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.docencia.fichero.fichero_Serializable.model.Note;

public class JsoServiceNoteTest {

    JsonServiceNote jsonServiceNote;
    Note note;

    @BeforeEach
    void beforeEach(){
        jsonServiceNote=new JsonServiceNote();
        note=new Note();
        note.setId("1");
        note.setTitle("Titulo");
        note.setContent("Contenido");
    }

    @Test
    void serializableNote(){
        String noteStr=jsonServiceNote.noteToString(note);
        Note noteTest= jsonServiceNote.stringToNote(noteStr);
        Assertions.assertEquals(note, noteTest, "Los elementos deben ser iguales");
    }

}
