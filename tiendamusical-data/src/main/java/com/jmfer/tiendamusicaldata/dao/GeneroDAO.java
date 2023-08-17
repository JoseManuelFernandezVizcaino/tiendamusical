/**
 * 
 */
package com.jmfer.tiendamusicaldata.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jmfer.tiendamusicalentities.entities.Genero;

/**
 * @author jmfer
 * DAO que contiene el CRUD para las transacciones con Sping JPA hacia la tabla de genero
 */
public interface GeneroDAO extends PagingAndSortingRepository<Genero, Long> {

}
