/**
 * 
 */
package com.jmfv.tiendamusicalservices.service;

import java.util.List;

import com.jmfv.tiendamusicalentities.dto.ArtistaAlbumDTO;

/**
 * @author jmfer
 * Interface que define los metodos de logica de negocio para la pantalla del home
 */
public interface HomeService {
	
	/**
	 * Metodo que permite consultar los albums con base al filtro que ingrese el cliente en el buscador de su home
	 * @param filtro
	 * @return
	 */
	List<ArtistaAlbumDTO> consultarAlbumsFiltro(String filtro);
}
