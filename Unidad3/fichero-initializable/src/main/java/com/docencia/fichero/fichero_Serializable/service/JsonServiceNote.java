package com.docencia.fichero.fichero_Serializable.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.docencia.fichero.fichero_Serializable.model.Note;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class JsonServiceNote extends ServiceNoteAbstract {
    JsonMapper jsonMapper;

    public JsonServiceNote(){
        jsonMapper=new JsonMapper();
    }

    private static Logger logger=LoggerFactory.getLogger(JsonServiceNote.class);

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
    public Note save(Note note) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public boolean delete() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public String noteToString(Note note) {
        String resultado=null;
        try {
            resultado=jsonMapper.writeValueAsString(note);
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("Se ha producido un error en la transformacion de note {}",note, e);;

        }
        return resultado;
    }

    @Override
    public Note stringToNote(String data) {
        Note resultado=null;
        try {
            resultado=jsonMapper.readValue(data, Note.class);
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("Se ha producido un error en la transformacion de data {}",data, e);;

        }
        return resultado;
    }

}
