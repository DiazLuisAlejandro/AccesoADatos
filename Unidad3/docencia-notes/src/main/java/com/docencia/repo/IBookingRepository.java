package com.docencia.repo;

import com.docencia.model.Booking;
import java.util.List;

/**
 * Repositorio para administrar entidades Booking.
 *
 * Responsabilidades principales:
 * - Consultar si un booking existe por su id
 * - Recuperar un booking por id
 * - Recuperar un booking usando un ejemplo parcial
 * - Listar todas los bookings
 * - Crear o actualizar un booking
 * - Borrar un booking por id
 */
public interface IBookingRepository {

    /**
     * Indica si existe un booking con el id dado.
     *
     * @param id identificador unico del booking
     * @return true si existe un booking con ese id, false en caso contrario
     */
    boolean exists(String id);

    /**
     * Busca un booking por su id.
     *
     * @param id identificador unico del booking
     * @return el booking encontrada, o null si no existe
     */
    Booking findById(String id);

    /**
     * Busca un booking que coincida con los campos relevantes del ejemplo dado.
     * La estrategia concreta depende de la implementacion (por ejemplo,
     * comparar por titulo o contenido).
     *
     * @param example objeto Booking usado como ejemplo de busqueda
     * @return un booking que cumpla con el criterio, o null si no hay coincidencia
     */
    Booking find(Booking example);

    /**
     * Devuelve todas los bookings almacenadas.
     *
     * @return lista con todas los bookings.
     */
    List<Booking> findAll();

    /**
     * Inserta o actualiza un booking.
     * - Si el booking no tiene id, la implementacion debe generarlo.
     * - Si el booking ya existe, se actualiza.
     *
     * @param booking entidad booking a guardar
     * @return el booking guardado, incluida la informacion final (por ejemplo el id asignado)
     */
    Booking save(Booking booking);

    /**
     * Elimina el booking con el id indicado.
     *
     * @param id identificador unico del booking
     * @return true si se borro un booking, false si no existia
     */
    boolean delete(String id);
}
