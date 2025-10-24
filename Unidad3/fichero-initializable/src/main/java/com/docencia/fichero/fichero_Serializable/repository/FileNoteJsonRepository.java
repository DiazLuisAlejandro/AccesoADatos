package com.docencia.fichero.fichero_Serializable.repository;

import com.fasterxml.jackson.databind.json.JsonMapper;


public class FileNoteJsonRepository extends FileNoteAbstractRepository{
    private static String nameFile="nombre-fichero.xml";
    private static JsonMapper mapper=new JsonMapper();
    public FileNoteJsonRepository(){
        super(nameFile,mapper);
    }
   
}
