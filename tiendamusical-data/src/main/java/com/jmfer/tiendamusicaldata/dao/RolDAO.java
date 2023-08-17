/**
 * 
 */
package com.jmfer.tiendamusicaldata.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jmfer.tiendamusicalentities.entities.Rol;

/**
 * @author jmfer
 * Interface que contiene los metodos del CRUD de SPRING JPA para la tabla de rol
 */
public interface RolDAO extends PagingAndSortingRepository<Rol, Long> {

}
