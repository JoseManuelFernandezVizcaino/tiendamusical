/**
 * 
 */
package com.jmfer.tiendamusicaldata.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jmfer.tiendamusicalentities.entities.Factura;
import com.jmfer.tiendamusicalentities.entities.Persona;

/**
 * @author jmfer
 * Interface que define los metodos para realizar el CRUD de la tabla de factura
 */
public interface FacturaDAO extends PagingAndSortingRepository<Factura, Long>{
	
	/**
	 * Metodo que permite consultar la lista de facturas de la persona que ha realizado comrpas
	 * @param persona
	 * @return
	 */
	List<Factura> findAllByPersona(Persona persona);
}
