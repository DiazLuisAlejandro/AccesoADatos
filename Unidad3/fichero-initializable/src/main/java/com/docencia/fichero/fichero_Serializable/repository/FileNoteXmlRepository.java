package com.docencia.fichero.fichero_Serializable.repository;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class FileNoteXmlRepository extends FileNoteAbstractRepository{
    private static String nameFile="nombre-fichero.xml";
    private static XmlMapper mapper=new XmlMapper();
    public FileNoteXmlRepository(){
        super(nameFile,mapper);
    }
}
