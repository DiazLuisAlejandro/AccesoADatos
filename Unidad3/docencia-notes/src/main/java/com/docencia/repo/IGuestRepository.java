package com.docencia.repo;

import com.docencia.model.Guest;
import java.util.List;

/**
 * Repositorio para administrar entidades Guest.
 *
 * Responsabilidades principales:
 * - Consultar si un guest existe por su id
 * - Recuperar un guest por id
 * - Recuperar un guest usando un ejemplo parcial
 * - Listar todas los guests
 * - Crear o actualizar un guest
 * - Borrar un guest por id
 */
public interface IGuestRepository {

    /**
     * Indica si existe un guest con el id dado.
     *
     * @param id identificador unico del guest
     * @return true si existe un guest con ese id, false en caso contrario
     */
    boolean exists(String id);

    /**
     * Busca un guest por su id.
     *
     * @param id identificador unico del guest
     * @return el guest encontrada, o null si no existe
     */
    Guest findById(String id);

    /**
     * Busca un guest que coincida con los campos relevantes del ejemplo dado.
     * La estrategia concreta depende de la implementacion (por ejemplo,
     * comparar por titulo o contenido).
     *
     * @param example objeto Guest usado como ejemplo de busqueda
     * @return un guest que cumpla con el criterio, o null si no hay coincidencia
     */
    Guest find(Guest example);

    /**
     * Devuelve todas los guests almacenadas.
     *
     * @return lista con todas los guests.
     */
    List<Guest> findAll();

    /**
     * Inserta o actualiza un guest.
     * - Si el guest no tiene id, la implementacion debe generarlo.
     * - Si el guest ya existe, se actualiza.
     *
     * @param guest entidad guest a guardar
     * @return el guest guardado, incluida la informacion final (por ejemplo el id asignado)
     */
    Guest save(Guest guest);

    /**
     * Elimina el guest con el id indicado.
     *
     * @param id identificador unico del guest
     * @return true si se borro un guest, false si no existia
     */
    boolean delete(String id);
}
