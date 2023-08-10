/**
 * 
 */
package com.jmfer.tiendamusicaldata.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jmfer.tiendamusicalentities.entities.CarritoAlbum;

/**
 * @author jmfer
 * Interface que implementa los metodos genericos para el CRUD con SPRING JPA hacia la tabla de carrito_album
 */
public interface CarritoAlbumDAO extends PagingAndSortingRepository<CarritoAlbum, Long> {

}