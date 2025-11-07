package com.docencia.repo;

import com.docencia.model.Room;
import java.util.List;

/**
 * Repositorio para administrar entidades Room.
 *
 * Responsabilidades principales:
 * - Consultar si un room existe por su id
 * - Recuperar un room por id
 * - Recuperar un room usando un ejemplo parcial
 * - Listar todas los rooms
 * - Crear o actualizar un room
 * - Borrar un room por id
 */
public interface IRoomRepository {

    /**
     * Indica si existe un room con el id dado.
     *
     * @param id identificador unico del room
     * @return true si existe un room con ese id, false en caso contrario
     */
    boolean exists(String id);

    /**
     * Busca un room por su id.
     *
     * @param id identificador unico del room
     * @return el room encontrada, o null si no existe
     */
    Room findById(String id);

    /**
     * Busca un room que coincida con los campos relevantes del ejemplo dado.
     * La estrategia concreta depende de la implementacion (por ejemplo,
     * comparar por titulo o contenido).
     *
     * @param example objeto Room usado como ejemplo de busqueda
     * @return un room que cumpla con el criterio, o null si no hay coincidencia
     */
    Room find(Room example);

    /**
     * Devuelve todas los room almacenadas.
     *
     * @return lista con todas los rooms.
     */
    List<Room> findAll();

    /**
     * Inserta o actualiza un room.
     * - Si el room no tiene id, la implementacion debe generarlo.
     * - Si el room ya existe, se actualiza.
     *
     * @param room entidad room a guardar
     * @return el room guardado, incluida la informacion final (por ejemplo el id asignado)
     */
    Room save(Room room);

    /**
     * Elimina el room con el id indicado.
     *
     * @param id identificador unico del room
     * @return true si se borro un room, false si no existia
     */
    boolean delete(String id);
}
