package com.docencia.objetos.domain;

// TODO: añadir validación (jakarta.validation) si se desea
public class Alumno {
  // TODO: definir campos y encapsulación
  private Long id;
  private String nombre;
  private String email;
  private String ciclo;

  /**
   * Constructor vacio
   */
  public Alumno() {
  }

  /**
   * Constructor con id
   * 
   * @param id alumno
   */
  public Alumno(Long id) {
    this.id = id;
  }

  /**
   * Constructor con todos los parámetros
   * 
   * @param id     alumno
   * @param nombre del alumno
   * @param email  del alumno
   * @param ciclo  del alumno
   */
  public Alumno(Long id, String nombre, String email, String ciclo) {
    this.id = id;
    this.nombre = nombre;
    this.email = email;
    this.ciclo = ciclo;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCiclo() {
    return ciclo;
  }

  public void setCiclo(String ciclo) {
    this.ciclo = ciclo;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Alumno other = (Alumno) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
