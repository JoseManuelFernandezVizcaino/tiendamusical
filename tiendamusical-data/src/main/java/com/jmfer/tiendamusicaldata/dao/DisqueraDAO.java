/**
 * 
 */
package com.jmfer.tiendamusicaldata.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jmfer.tiendamusicalentities.entities.Disquera;

/**
 * @author jmfer
 * Clase que representa el DAO para el CRUD hacia la tabla de Disqueras.
 */
public interface DisqueraDAO extends PagingAndSortingRepository<Disquera, Long> {

}
