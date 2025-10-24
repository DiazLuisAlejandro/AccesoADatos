package com.docencia.fichero.fichero_Serializable.model;

import java.util.Objects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


/**
 * Clase note que almacena información
 * @author Alejandro Díaz Luis
 * @version 1.0.0
 */
public class Note {

    @NotBlank
    private String id;

    @NotBlank @Size(max=200)
    private String title;

    @NotBlank
    private String content;

    
    /**
     *  Constructor vacio
     */
    public Note(){}

    /**
     * Constructor con parametros
     * @param id de la nota
     */
    public Note(String id){
        this.id=id;
    }

    /**
     * Constructor con parametros
     * @param id de la nota
     * @param title de la nota
     * @param content de la nota
     */
    public Note(String id,String title, String content){
        this.title=title;
        this.id=id;
        this.content=content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Note other = (Note) obj;
        return Objects.equals(id, other.id);
    }

    
    

}
