/**
 * 
 */
package com.jmfv.tiendamusicaldata.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jmfv.tiendamusicalentities.entities.CarritoAlbum;

/**
 * @author jmfer
 * Interface que implementa los metodo genericos para que le CRUD con SPRING JPA hacia la tabla carrito_album
 */
public interface CarritoAlbumDAO extends PagingAndSortingRepository<CarritoAlbum, Long> {

}
