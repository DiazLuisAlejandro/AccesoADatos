package com.docencia.fichero.fichero_Serializable.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.docencia.fichero.fichero_Serializable.model.Note;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlServiceNote extends ServiceNoteAbstract{
    XmlMapper xmlMapper;

    public XmlServiceNote(){
        xmlMapper=new XmlMapper();
    }

    private static Logger logger=LoggerFactory.getLogger(XmlServiceNote.class);


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
            resultado=xmlMapper.writeValueAsString(note);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            logger.error("Se ha producido un error en la transformacion de note {}",note, e);;

        }
        return resultado;
    }

    @Override
    public Note stringToNote(String data) {
         Note note=null;
        try {
            note= xmlMapper.readValue(data, Note.class);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            logger.error("Se ha producido un error en la transformacion de data {}",data, e);;
        }
        return note;
    }
}
