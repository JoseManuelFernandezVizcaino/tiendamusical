/**
 * 
 */
package com.jmfer.tiendamusicaldata.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.jmfer.tiendamusicalentities.entities.SubGenero;

/**
 * @author jmfer
 * DAO que contiene el CRUD para las transacciones con Sping JPA hacia la tabla de subgenero
 */
public interface SubGeneroDAO extends PagingAndSortingRepository<SubGenero, Long> {
	
	/**
	 * Metodo que permite consultar con Spring JPA los subgeneros de un genero seleccionado
	 * @param idGenero
	 * @return
	 */
	@Query("SELECT sb FROM SubGenero sb WHERE sb.genero.idGenero = :idGenero")
	List<SubGenero> findAllByGenero(@Param("idGenero")Long idGenero);
}
