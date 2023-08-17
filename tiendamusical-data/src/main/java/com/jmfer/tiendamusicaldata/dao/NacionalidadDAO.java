/**
 * 
 */
package com.jmfer.tiendamusicaldata.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jmfer.tiendamusicalentities.entities.Nacionalidad;

/**
 * @author jmfer
 * DAO que contiene el CRUD para las transacciones con Sping JPA hacia la tabla de nacionalidad
 */
public interface NacionalidadDAO extends PagingAndSortingRepository<Nacionalidad, Long> {

}
