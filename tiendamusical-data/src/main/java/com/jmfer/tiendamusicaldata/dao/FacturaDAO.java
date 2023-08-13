/**
 * 
 */
package com.jmfer.tiendamusicaldata.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jmfer.tiendamusicalentities.entities.Factura;

/**
 * @author jmfer
 * Interface que define los metodos para realizar el CRUD de la tabla de factura
 */
public interface FacturaDAO extends PagingAndSortingRepository<Factura, Long>{

}
